import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Block extends DisplayObject implements Serializable {
    Bonus bonus;
    public int hardness;

    public Block(int x, int y, int width, int height, int colorR, int colorG, int colorB, int hardness) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.x1 = x - width/2;
        this.x2 = x + width/2;
        this.y1 = y - height/2;
        this.y2 = y + height/2;
        this.colorR = colorR;
        this.colorG = colorG;
        this.colorB = colorB;
        this.hardness = hardness;
        this.type = 2;
        this.movable = 0;
        this.visible = 1;
    }
    public void chSize(int x, int width){
        this.x = x;
        this.width = width;
        this.x1 = x - width/2;
        this.x2 = x + width/2;
    }
    Block()
    {

    }
    public void changeHardness(){
        this.hardness--;
        switch (this.hardness) {
            case 0:
                visible = 0;
                x= 0;
                y = 0;
                x1 = 0;
                y1 = 0;
                x2 = 0;
                y2 = 0;
                break;
            case 1:
                this.colorR = Color.BLUE.getRed();
                this.colorG = Color.BLUE.getGreen();
                this.colorB = Color.BLUE.getBlue();
                break;
            case 2:
                this.colorR = Color.CYAN.getRed();
                this.colorG = Color.CYAN.getGreen();
                this.colorB = Color.CYAN.getBlue();
                break;
        }
    }
    public void setHardness(int hardness) {
        this.hardness = hardness;
    }

    public int getHardness() {
        return hardness;
    }

    public void getBonus(Bonus bonus){

    }

    @Override
    public void move() {

    }
    @Override public void draw(Graphics2D g2d){
        if (visible == 1){
            g2d.setColor(new Color(colorR,colorG,colorB));
            Rectangle rect = new Rectangle(x1,y1,width,height);
            g2d.fill(rect);
            g2d.draw(rect);
        }
    }
    @Override
    public void toString(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            writer.println(getClass().getName());
            writer.println(x + "," + y + "," + width + "," + height + "," + colorR + "," + colorG + "," + colorB + "," + hardness + "," + visible);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void fromString(String inf) {
        String[] date = inf.split(",");
        this.x = Integer.parseInt(date[0]);
        this.y = Integer.parseInt(date[1]);
        this.width = Integer.parseInt(date[2]);
        this.height = Integer.parseInt(date[3]);
        this.x1 = x - width/2;
        this.x2 = x + width/2;
        this.y1 = y - height/2;
        this.y2 = y + height/2;
        this.colorR = Integer.parseInt(date[4]);
        this.colorG = Integer.parseInt(date[5]);
        this.colorB = Integer.parseInt(date[6]);
        this.hardness = Integer.parseInt(date[7]);
        this.type = 2;
        this.movable = 0;
        this.visible = Integer.parseInt(date[8]);
    }
}
