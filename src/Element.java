import java.awt.*;

public abstract class Element {
    private int x;
    private int y;
    private String color;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getColor() {
        return color;
    }

    public Element(String color,int x, int y){
        this.color = color;
        this.x = x;
        this.y = y;
    }

    abstract void move();
}
