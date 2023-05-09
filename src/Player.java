import java.awt.*;

public class Player {
    PlayerStatistic stat;
    Platform platform;
    Balls balls;
    Player(){
        stat = new PlayerStatistic();
        platform = new Platform(500,715,200,30, Color.YELLOW.getRed(), Color.YELLOW.getGreen(), Color.YELLOW.getBlue(),12);
        balls = new Balls();
    }

    public void fail(){
        stat.lives--;
        StatisticsBar.updStat();
        if (stat.lives <= 0)
            Game.pause();
        platform = new Platform(500,715,200,30, Color.YELLOW.getRed(), Color.YELLOW.getGreen(), Color.YELLOW.getBlue(),12);
        balls = new Balls();
        Game.gameField.allObj.allObj[27] = platform;
        Game.gameField.allObj.activePlatform = platform;
        Game.gameField.allObj.allObj[28] = balls.balls[0];
    }
    public String getPlayerStatistic(){
        return "        Name: " + stat.name + "         Score: " + Integer.toString(stat.score) + "         Lives: " + Integer.toString(stat.lives);
    }
}
