public class Block extends Element {
    private int width,height;

    public Block(String color, int x, int y, int width, int height) {
        super(color, x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    void move() {

    }
}
