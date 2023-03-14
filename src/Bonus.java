import java.awt.*;

public class Bonus extends DisplayObject {
    public int bonusType;

    public Bonus(int x, int y, int x1, int y1, int width, int height, Color color, int type, boolean movable,int bonusType) {
        super(x, y, x1, y1, width, height, color, type, movable);
        this.bonusType = bonusType;
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
}
