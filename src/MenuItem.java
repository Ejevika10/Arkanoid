import java.awt.*;

public class MenuItem extends DisplayObject {

    String someInfo;

    public MenuItem(int x, int y, int x1, int y1, int width, int height, Color color, int type, boolean movable) {
        super(x, y, x1, y1, width, height, color, type, movable);
    }


    @Override
    public void move() {

    }

    @Override
    public boolean checkCollision(DisplayObject elem) {
        return false;
    }

    @Override
    public void draw(Graphics2D g2d) {

    }

    void onClick(){

    }
}
