import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Block extends DisplayObject implements Serializable, Observer {
    Bonus bonus;
    ArrayList<Point> points;
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
        this.points = new ArrayList<>();
        for (int i = 0; i < hardness; i++){
            this.points.add(new Point(x,y,20));
        }
        this.type = 2;
        this.movable = 0;
        this.visible = 2;
        this.bonus = new Bonus(x,y,width,height);
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

    @Override
    public void move() {

    }
    @Override public void draw(Graphics2D g2d){
        if (visible == 2){
            g2d.setColor(new Color(colorR,colorG,colorB));
            Rectangle rect = new Rectangle(x1,y1,width,height);
            g2d.fill(rect);
            g2d.draw(rect);
        }
    }
    @Override
    public void toString(String filename){

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {

            writer.println(getClass().getName());
            writer.println(x + "," + y + "," + width + "," + height + "," + colorR + "," + colorG + "," + colorB + "," + hardness + "," + visible);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void fromString(String inf) {
        try {
            FileInputStream fis = new FileInputStream("New.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Block block = (Block) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
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

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof EventBlock && ((EventBlock) arg).block.equals(this)){
            if (hardness < 100){
                ((EventBlock) arg).block.points.get(0).getPoint();
                this.hardness--;
                Game.players.players[0].stat.score++;
                switch (this.hardness) {
                    case 0 -> {
                        bonus.startBonus();
                        visible = 0;
                        x = 0;
                        y = 0;
                        x1 = 0;
                        y1 = 0;
                        x2 = 0;
                        y2 = 0;
                    }
                    case 1 -> {
                        this.colorR = Color.GREEN.getRed();
                        this.colorG = Color.GREEN.getGreen();
                        this.colorB = Color.GREEN.getBlue();
                    }
                    case 2 -> {
                        this.colorR = Color.CYAN.getRed();
                        this.colorG = Color.CYAN.getGreen();
                        this.colorB = Color.CYAN.getBlue();
                    }
                }
            }
        }

    }
}
