import java.awt.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.Field;

public abstract class DisplayObject {
    public int x;
    public int y;
    public int x1;
    public int y1;
    public int x2;
    public int y2;
    public int width;
    public int height;
    public int colorR;
    public int colorG;
    public int colorB;
    public int type;
    public int movable;
    public int visible;

    public void changeDirection(int i){
    };
    public boolean checkCollision(DisplayObject elem){
        boolean res = false;
        if(y2 >= elem.y1 && y1 <= elem.y2)
            if (x2 >= elem.x1 && x1 <= elem.x2)
            {
                if(y1 >= elem.y2 || y2 <= elem.y1)
                {
                    changeDirection(1);
                }
                else
                {
                    changeDirection(2);
                }
                res = true;
            }
        return res;
    }
    public abstract void draw(Graphics2D g2d);
    public void move(){}
    public void toString(String filename){}

    public void fromString(String readLine) {}

}
