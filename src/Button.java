import java.awt.*;

public class Button extends DisplayObject{


    public Button(int x, int y, int x1, int y1, int x2, int y2, int width, int height, Color color, int type, int movable, int visible) {
        //super(x, y, x1, y1, x2, y2, width, height, color, type, movable, visible);
    }

    void onClick(){

    }


    @Override
    public void move() {

    }

    @Override
    public boolean checkCollision(DisplayObject obj) {
        return false;
    }

    @Override
    public void draw(Graphics2D g2d) {

    }
}
