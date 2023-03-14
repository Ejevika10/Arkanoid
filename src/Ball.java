import java.awt.*;

public class Ball extends DisplayObject {
    public int radius;
    float angle;

    public Ball(int x, int y, int x1, int y1, int width, int height, Color color, int type, boolean movable,int radius,float angle) {
        super(x, y, x1, y1, width, height, color, type, movable);
        this.radius = radius;
        this.angle = angle;
    }

    @Override
    public void move() {
    }
    @Override
    public boolean checkCollision(DisplayObject elem) {
        return false;
    }
    @Override
    public void draw(Graphics2D g2d){
        g2d.setColor(Color.RED);
        g2d.fillOval(x,y,width,height);
    }
}

