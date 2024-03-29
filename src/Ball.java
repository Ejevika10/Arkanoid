import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ball extends DisplayObject implements Serializable, Observer {
    public int radius;
    public int speed;
    public float angle;

    public Ball(int x, int y, int radius, int colorR, int colorG, int colorB, float angle,int speed) {
        this.x = x;
        this.y = y;
        this.colorR = colorR;
        this.colorG = colorG;
        this.colorB = colorB;
        this.radius = radius;
        this.x1 = x - radius;
        this.x2 = x + radius;
        this.y1 = y - radius;
        this.y2 = y + radius;
        this.width = radius * 2;
        this.height = radius * 2;
        this.angle = angle;
        this.speed = speed;
        this.movable = 1;
        this.visible = 1;
        this.type = 1;
    }
    Ball()
    {

    }

    @Override
    public void move() {
        if (x1 <= 0 || x2 >= Game.gameField.width - 135)
            changeDirection(2);
        else if (y1 <= 0)
            changeDirection(1);
        else if (y2 >= Game.gameField.height)
            dropDown();

        float dx = (float) Math.cos(angle) * speed;
        float dy = (float) Math.sin(angle) * speed;
        x1 = (int)(x1  + dx);
        x2 = (int)(x2 + dx);
        x = (int)(x + dx);
        y1 = (int)(y1 + dy);
        y2 = (int)(y2 + dy);
        y = (int)(y + dy);
    }
    @Override
    public void draw(Graphics2D g2d){
        g2d.setColor(new Color(colorR,colorG,colorB));
        g2d.fillOval(x1,y1,width,height);
    }

    @Override
    public void toString(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            writer.println(getClass().getName());
            writer.println(x + "," + y + "," + radius + "," + colorR + "," + colorG + "," + colorB + "," + angle + "," + speed);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void fromString(String inf) {
        String[] date = inf.split(",");
        this.x = Integer.parseInt(date[0]);
        this.y = Integer.parseInt(date[1]);
        this.radius = Integer.parseInt(date[2]);
        this.colorR = Integer.parseInt(date[3]);
        this.colorG = Integer.parseInt(date[4]);
        this.colorB = Integer.parseInt(date[5]);
        this.x1 = x - radius;
        this.x2 = x + radius;
        this.y1 = y - radius;
        this.y2 = y + radius;
        this.width = radius * 2;
        this.height = radius * 2;
        this.angle = Float.parseFloat(date[6]);
        this.speed = Integer.parseInt(date[7]);
        this.movable = 1;
        this.visible = 1;
        this.type = 1;
    }
    @Override
    public void changeDirection(int i){
        switch (i) {
            case 1 -> angle = -angle;
            case 2 -> angle = (float) Math.PI - angle;
        }
    }
    void chSize(int width,int height){
        this.x = (width - 135)/2;
        this.y = height - 115;
        this.x1 = x - radius;
        this.x2 = x + radius;
        this.y1 = y - radius;
        this.y2 = y + radius;
    }

    public void dropDown(){
        Game.gameField.allObj.allObj.remove(this);
        Game.players.players[0].balls.balls.remove(this);
        Game.gameField.allObj.ballCounter--;
        if (Game.players.players[0].balls.balls.size() == 0){
            Game.players.players[0].stat.lives--;
            StatisticsBar.updStat();
            if (Game.players.players[0].stat.lives <= 0){
                Game.gameOver();
            }

            Balls balls = new Balls(Game.gameField.width,Game.gameField.height);
            Game.gameField.allObj.allObj.addAll(balls.balls);
            Game.players.players[0].balls.balls.addAll(balls.balls);

            Game.gameField.allObj.activePlatform.setCenter();
            Game.gameField.allObj.ballCounter = 1;
        }
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}

