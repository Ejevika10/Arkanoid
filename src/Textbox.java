import java.awt.*;

public class Textbox extends DisplayObject{

    String text;


    public Textbox(int x, int y, int x1, int y1, int width, int height, Color color, int type, boolean movable) {
        super(x, y, x1, y1, width, height, color, type, movable);
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