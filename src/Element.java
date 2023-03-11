import java.awt.*;

public abstract class Element {
    private int x;
    private int y;
    private int width;
    private int height;
    private int color;

    private int type;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Element(int color, int x, int y, int width, int height, int type){
        this.color = color;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.type = type;
    }

    abstract void move();

    public void checkCollision(){

    }
    public void draw(){

    }
}
