import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;

public class Platform extends DisplayObject {
    public int speed;
    KeyEvent key;
    public Platform(int x, int y, int width, int height, Color color,int speed) {
        this.x = x;
        this.y = y;
        this.x1 = x - width/2;
        this.x2 = x + width/2;
        this.y1 = y - height/2;
        this.y2 = y + height/2;
        this.width = width;
        this.height = height;
        this.setColor(color);
        this.type = 3;
        this.movable = 1;
        this.visible = 1;
        this.speed = speed;
    }

    void changeWidth(){

    }

    @Override
    public void move() {
        if (key != null){
            int keyCode = key.getKeyCode();
            if (keyCode == KeyEvent.VK_LEFT){
                setX1(getX1() - speed);
                setX2(getX2() - speed);
                setX(getX() - speed);
            }
            else if(keyCode == KeyEvent.VK_RIGHT){
                setX1(getX1() + speed);
                setX2(getX2() + speed);
                setX(getX() + speed);
            }
            if(getX1() < 0){
                setX1(0);
                setX2(width);
                setX(width/2);
            }
            else if(getX2() > 1015){
                setX1(1015 - width);
                setX2(1015);
                setX(1015 - width/2);
            }
        }
    }

    @Override
    public boolean checkCollision(DisplayObject elem) {
        return false;
    }
    @Override public void draw(Graphics2D g2d){
        g2d.setColor(getColor());
        Rectangle rect = new Rectangle(x1,y1,width,height);
        g2d.fill(rect);
        g2d.draw(rect);
    }

}
