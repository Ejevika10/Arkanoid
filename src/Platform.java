public class Platform extends Element{
    private int width,height;

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

    public Platform(String color, int x, int y, int width, int height) {
        super(color, x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    void move() {

    }
}
