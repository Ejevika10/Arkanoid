import java.awt.*;

public class Point extends DisplayObject{
    Point(int x, int y, int rad){
        this.x = x;
        this.y = y;
        this.width = rad*2;
        this.height = rad*2;
        this.x1 = x - rad;
        this.x2 = x + rad;
        this.y1 = y - rad;
        this.y2 = y + rad;
        this.type = 5;
        this.movable = 0;
        this.visible = 0;
    }
    public  void getPoint(){
        movable = 1;
        visible = 1;
    }
    @Override
    public void move() {
        y += 10;
        y1 += 10;
        y2 += 10;
        if (y1 >= Game.gameField.height){
            visible = 0;
            movable = 0;
        }

    }
    @Override
    public void draw(Graphics2D g2d) {
        if (visible == 1){
            Font font = new Font("Serif", Font.PLAIN, 24);
            g2d.setFont(font);
            g2d.setColor(Color.BLACK);
            String tempString = "1";
            g2d.drawString(tempString, x1, y1 + 2*height/3);
        }
    }
}
