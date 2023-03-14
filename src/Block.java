import java.awt.*;

public class Block extends DisplayObject {
    Bonus bonus;
    public int hardness;

    public Block(int x, int y, int x1, int y1, int width, int height, Color color, int type, boolean movable, int hardness) {
        super(x, y, x1, y1, width, height, color, type, movable);
        this.hardness = hardness;
    }

    public void getBonus(Bonus bonus){

    }

    @Override
    public void move() {

    }

    @Override
    public boolean checkCollision(DisplayObject elem) {
        return false;
    }
    @Override public void draw(Graphics2D g2d){
        g2d.setColor(this.color);
        Rectangle rect = new Rectangle(x,y,width,height);
        g2d.fill(rect);
        g2d.draw(rect);
    }
}
