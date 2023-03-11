public class Ball extends Element{
    private int radius;

    public int getRadius() {
        return radius;
    }

    public Ball(int color, int x, int y, int height, int width, int type, int radius) {
        super(color, x, y,width,height,type);
        this.radius = radius;
    }

    @Override
    void move() {

    }
}
