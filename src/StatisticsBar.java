import java.awt.*;

public class StatisticsBar extends DisplayObject {
    Textbox fullStatistic;
    PlayerStatistic[] stat;
    Button[] btn;

    public StatisticsBar(int x, int y, int x1, int y1,int x2, int y2, int width, int height, Color color, int type, int movable,int visible, String stat) {
        //super(x, y, x1, y1, x2, y2, width, height, color, type, movable,visible);
        this.fullStatistic.text = stat;
    }
    public void updStat(Players players){
        fullStatistic.text = players.getFullStatistic();
    }
    @Override
    public void move() {

    }
    @Override
    public void changeDirection(int i) {

    }
    @Override
    public void draw(Graphics2D g2d) {

    }
}
