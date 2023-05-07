import java.awt.*;

public class Bonus extends DisplayObject {
    public int bonusType;

    public Bonus(int x, int y, int x1, int y1, int x2, int y2, int width, int height, Color color, int type, int movable, int visible,int bonusType) {
        //super(x, y, x1, y1, x2, y2, width, height, color, type, movable, visible);
        this.bonusType = bonusType;
    }


    @Override
    public void move() {

    }

    @Override
    public void draw(Graphics2D g2d) {

    }
}
