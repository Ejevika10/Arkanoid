import java.awt.*;
import java.util.ArrayList;

public class Platforms {
    ArrayList<Platform> platforms;
    int pos = 0;

    Platforms(int width,int height){
        platforms = new ArrayList<>();
        platforms.add(new Platform((width - 135)/2, height-85, 200,30, Color.YELLOW.getRed(), Color.YELLOW.getGreen(), Color.YELLOW.getBlue(),12));
    }
}
