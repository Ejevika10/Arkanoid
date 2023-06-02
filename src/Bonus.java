import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Bonus extends DisplayObject implements Observer {
    public int bonusType;
    public int bonusPoint;
    public Bonus(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.x1 = x - width/2;
        this.x2 = x + width/2;
        this.y1 = y - height/2;
        this.y2 = y + height/2;
        this.type = 4;
        this.movable = 0;
        this.visible = 0;
        this.bonusType = (int)(Math.random() * 5  + 1);
        this.bonusPoint = (int)(Math.random() * 5  + 40);
    }
    Bonus()
    {

    }

    @Override
    public void move() {
        y += 5;
        y1 += 5;
        y2 += 5;
        if (y1 >= Game.gameField.height){
            visible = 0;
            movable = 0;
        }

    }

    @Override
    public void draw(Graphics2D g2d) {
        if (visible == 1){
            g2d.setColor(Color.ORANGE);
            g2d.fillOval(x1,y1,width,height);

            Font font = new Font("Serif", Font.PLAIN, 24);
            g2d.setFont(font);
            g2d.setColor(Color.BLACK);
            String tempString = "";
            switch (bonusType){
                case 1: tempString = "    + " + bonusPoint;
                break;
                case 2: tempString = "  + lives";
                break;
                case 3: tempString = "  - speed";
                break;
                case 4: tempString = "  + width";
                    break;
                case 5: tempString = "  - width";
                    break;
            }
            g2d.drawString(tempString, x1, y1 + 2*height/3);
        }
    }
    public void startBonus(){
        visible = 1;
        movable = 1;
    }
    public void getBonus(){

    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof EventBonus && ((EventBonus) arg).bonus.equals(this)){
            switch (bonusType) {
                case 1 -> {
                    Game.players.players[0].stat.score += bonusPoint;
                    Game.players.players[0].balls.balls.get(0).speed = 10;
                    Game.gameField.allObj.activePlatform.changeWidthBonus(200);

                    break;
                }
                case 2 -> {
                    //Game.gameField.allObj.ballCounter++;
                    Game.players.players[0].stat.lives++;
                    Game.players.players[0].balls.balls.get(0).speed = 10;
                    Game.gameField.allObj.activePlatform.changeWidthBonus(200);

                    break;
                }
                case 3 -> {
                    Game.players.players[0].balls.balls.get(0).speed = 5;
                    Game.gameField.allObj.activePlatform.changeWidthBonus(200);
                    StatisticsBar.updStat();
                    break;
                }
                case 4 -> {
                    Game.gameField.allObj.activePlatform.changeWidthBonus(300);
                    Game.players.players[0].balls.balls.get(0).speed = 10;
                    break;
                }
                case 5 -> {
                    Game.gameField.allObj.activePlatform.changeWidthBonus(100);
                    Game.players.players[0].balls.balls.get(0).speed = 10;
                    break;
                }
            }
            visible = 0;
            movable = 0;
        }
    }
}
