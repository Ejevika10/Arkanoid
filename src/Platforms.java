import java.awt.*;

public class Platforms {
    Platform[] platforms;
    int pos = 0;

    Platforms(){
        platforms = new Platform[1];
        platforms[0] = new Platform(175,270,255,290,80,20, Color.YELLOW,3,true);
        addPlatform(platforms[0]);
    }
    public void addPlatform(Platform platform){
        platforms[pos] = platform;
        pos++;
    }

}
