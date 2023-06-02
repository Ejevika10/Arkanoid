import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

public class Player implements Serializable {
    public  PlayerStatistic stat;
    Platform platform;
    Balls balls;
    Player(){
        stat = new PlayerStatistic();
        platform = Game.gameField.allObj.platform.platforms.get(0);
        balls = Game.gameField.allObj.balls;
    }
    public String getPlayerStatistic(){
        return "        Name: " + stat.name + "         Score: " + Integer.toString(stat.score) + "         Lives: " + Integer.toString(stat.lives);
    }
    public void toString(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            writer.println(getClass().getName());
            writer.println(stat.name + "," + stat.score + "," + stat.lives);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void fromString(String content) {
        String[] parts = content.split(",");
        stat.name=parts[0];
        stat.score=(Integer.parseInt(parts[1]));
        stat.lives=(Integer.parseInt(parts[2]));
    }

}
