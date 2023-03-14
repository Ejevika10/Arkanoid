import java.awt.*;

public class StatisticsBar extends DisplayObject {
    String fullStatistic;

    public StatisticsBar(int x, int y, int x1, int y1, int width, int height, Color color, int type, boolean movable,String stat) {
        super(x, y, x1, y1, width, height, color, type, movable);
        this.fullStatistic = stat;
    }
    public void updStat(Players players){
        fullStatistic = players.getFullStatistic();
    }
    @Override
    public void move() {

    }
    @Override
    public boolean checkCollision(DisplayObject elem) {
        return false;
    }

    @Override
    public void draw(Graphics2D g2d) {

    }
}
