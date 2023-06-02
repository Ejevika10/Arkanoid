import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
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
        int distX = Math.abs(x - elem.x) - elem.width/2;
        int distY = Math.abs(y - elem.y) - elem.height/2;

        if (distX + 1 < this.width/2 && distY + 1 < this.width/2) {
            res = true;
            if (distX < distY)
                changeDirection(1);
            else
                changeDirection(2);
        }
        return res;
    }
    public abstract void draw(Graphics2D g2d);
    public void move(){}
    public void toString(String filename) throws IOException {}
    public void fromString(String readLine) {}

}
