public class Ball extends Element{
    private int diametr;

    public int getDiametr() {
        return diametr;
    }

    public Ball(String color, int x, int y, int diametr) {
        super(color, x, y);
        this.diametr = diametr;
    }

    @Override
    void move() {

    }
}
