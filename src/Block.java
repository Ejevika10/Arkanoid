import java.awt.*;

public class Block extends DisplayObject {
    Bonus bonus;
    private int hardness;

    public Block(int x, int y, int width, int height, Color color, int hardness) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.x1 = x - width/2;
        this.x2 = x + width/2;
        this.y1 = y - height/2;
        this.y2 = y + height/2;
        this.setColor(color);
        this.hardness = hardness;
        this.type = 2;
        this.movable = 0;
        this.visible = 1;
    }

    public void setHardness(int hardness) {
        this.hardness = hardness;
    }

    public int getHardness() {
        return hardness;
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
        if (getHardness() > 0){
            g2d.setColor(this.getColor());
            Rectangle rect = new Rectangle(x1,y1,width,height);
            g2d.fill(rect);
            g2d.draw(rect);
        }
        else{
            visible = 0;
            setX(0);
            setY(0);
            setX1(0);
            setY1(0);
            setX2(0);
            setY2(0);
        }
    }
}
