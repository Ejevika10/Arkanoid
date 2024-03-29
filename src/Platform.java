import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Platform extends DisplayObject implements Serializable {
    public int speed;
    KeyEvent key;
    public Platform(int x, int y, int width, int height, int colorR, int colorG, int colorB,int speed) {
        this.x = x;
        this.y = y;
        this.x1 = x - width/2;
        this.x2 = x + width/2;
        this.y1 = y - height/2;
        this.y2 = y + height/2;
        this.width = width;
        this.height = height;
        this.colorR = colorR;
        this.colorG = colorG;
        this.colorB = colorB;
        this.type = 3;
        this.movable = 1;
        this.visible = 2;
        this.speed = speed;
    }
    Platform()
    {

    }
    void changeWidthBonus(int widthNew){
        this.width = widthNew;
        this.x1 = x - widthNew/2;
        this.x2 = x + widthNew/2;
    }
    void chSize(int width,int height){
        this.x = (width - 135)/2;
        this.y = height - 85;
        this.x1 = x - this.width/2;
        this.x2 = x + this.width/2;
        this.y1 = y - this.height/2;
        this.y2 = y + this.height/2;
    }
    public void setCenter(){
        this.x = (Game.gameField.width - 135)/2;
        this.y = Game.gameField.height - 85;
        this.x1 = x - this.width/2;
        this.x2 = x + this.width/2;
        this.y1 = y - this.height/2;
        this.y2 = y + this.height/2;

    }
    @Override
    public void move() {
        if (key != null){
            int keyCode = key.getKeyCode();
            if (keyCode == KeyEvent.VK_LEFT){
                x1 -= speed;
                x2 -= speed;
                x -= speed;
            }
            else if(keyCode == KeyEvent.VK_RIGHT){
                x1 += speed;
                x2 += speed;
                x += speed;
            }
            if(x1 < 0){
                x1 = 0;
                x2 = width;
                x = width/2;
            }
            else if(x2 > Game.gameField.width - 135){
                x1 = Game.gameField.width - 135 - width;
                x2 = Game.gameField.width - 135;
                x = Game.gameField.width - 135 - width/2;
            }
        }
    }
    @Override
    public void toString(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            writer.println(getClass().getName());
            writer.println(x + "," + y + "," + width + "," + height + "," + colorR + "," + colorG + "," + colorB + "," + speed);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void fromString(String inf) {
        String[] date = inf.split(",");
        this.x = Integer.parseInt(date[0]);
        this.y = Integer.parseInt(date[1]);
        this.x1 = x - width/2;
        this.x2 = x + width/2;
        this.y1 = y - height/2;
        this.y2 = y + height/2;
        this.width = Integer.parseInt(date[2]);
        this.height = Integer.parseInt(date[3]);
        this.colorR = Integer.parseInt(date[4]);
        this.colorG = Integer.parseInt(date[5]);
        this.colorB = Integer.parseInt(date[6]);
        this.type = 3;
        this.movable = 1;
        this.visible = 1;
        this.speed = Integer.parseInt(date[7]);   }
    @Override public void draw(Graphics2D g2d){
        g2d.setColor(new Color(colorR,colorG,colorB));
        Rectangle rect = new Rectangle(x1,y1,width,height);
        g2d.fill(rect);
        g2d.draw(rect);
    }
}
