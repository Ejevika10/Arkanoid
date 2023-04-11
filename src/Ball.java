import java.awt.*;

import static java.lang.Math.PI;

public class Ball extends DisplayObject {
    public int radius;
    int speed;
    private float angle;

    public Ball(int x, int y, int radius, Color color, float angle,int speed) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.x1 = x - radius;
        this.x2 = x + radius;
        this.y1 = y - radius;
        this.y2 = y + radius;
        this.width = radius * 2;
        this.height = radius * 2;
        this.angle = angle;
        this.speed = speed;
        this.movable = 1;
        this.visible = 1;
        this.type = 1;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    @Override
    public void move() {
        if (getX1() <= 0 || getX2()>=1015)
            setAngle((float)PI - getAngle());
        else if (getY1()<=0)
            setAngle( - getAngle());

        float dx = (float) Math.cos(angle) * speed;
        float dy = (float) Math.sin(angle) * speed;

        setX1((int)(getX1() + dx));
        setX2((int)(getX2() + dx));
        setX((int)(getX() + dx));
        setY1((int)(getY1() + dy));
        setY2((int)(getY2() + dy));
        setY((int)(getY() + dy));
    }
    @Override
    public boolean checkCollision(DisplayObject elem) {
        int xDist = Math.abs(this.getX() - elem.getX())-elem.width/2;
        int yDist = Math.abs(this.getY() - elem.getY())-elem.height/2;
        if (xDist <= this.radius && yDist <= this.radius) {
            if (xDist <= yDist){         //from top or bottom
                setAngle( - getAngle());
            }
            else{                       // from left or right
                setAngle((float)PI - getAngle());
            }
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public void draw(Graphics2D g2d){
        g2d.setColor(Color.RED);
        g2d.fillOval(x1,y1,width,height);
    }
}

