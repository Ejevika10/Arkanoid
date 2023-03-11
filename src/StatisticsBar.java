public class StatisticsBar extends Element {
    String stat;


    public StatisticsBar(int color, int x, int y, int width, int height, int type, String stat) {
        super(color, x, y, width, height, type);
        this.stat = stat;
    }

    @Override
    void move() {

    }
}
