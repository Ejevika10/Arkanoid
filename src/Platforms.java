import java.awt.*;

public class Platforms {
    Platform[] platforms;
    int pos = 0;

    Platforms(){
        platforms = new Platform[1];
        platforms[0] = Game.players.players[0].platform;
        addPlatform(platforms[0]);
    }
    public void addPlatform(Platform platform){
        platforms[pos] = platform;
        pos++;
    }

}
