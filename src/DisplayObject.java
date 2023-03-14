import java.awt.*;

public abstract class DisplayObject {
    public int x;
    public int y;

    public int x1;
    public int y1;
    public int width;
    public int height;
    public Color color;
    public int type;
    public boolean movable;

    public DisplayObject(int x, int y,int x1, int y1, int width, int height,Color color, int type,boolean movable){
        this.x = x;
        this.y = y;
        this.x1 = x1;
        this.y1 = y1;
        this.width = width;
        this.height = height;
        this.color = color;
        this.type = type;
        this.movable=movable;
    }

    public abstract void move();
    public abstract boolean checkCollision(DisplayObject obj);
    public abstract void draw(Graphics2D g2d);
}
