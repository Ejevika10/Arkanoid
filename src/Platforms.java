import java.awt.*;

public class Platforms {
    Platform[] platforms;
    int pos = 0;

    Platforms(){
        platforms = new Platform[1];
        platforms[0] = new Platform(500,715,200,30, Color.YELLOW.getRed(), Color.YELLOW.getGreen(), Color.YELLOW.getBlue(),12);
        addPlatform(platforms[0]);
    }
    public void addPlatform(Platform platform){
        platforms[pos] = platform;
        pos++;
    }

}
