import java.awt.*;
import java.util.ArrayList;

import static java.lang.Math.PI;

public class Balls {
    public ArrayList<Ball> balls;
    //int pos = 0;
    Balls(int width, int height){
        balls = new ArrayList<>();
        addBall(new Ball((width - 135)/2, height - 115, 15,Color.RED.getRed(),Color.RED.getGreen(), Color.RED.getBlue(),(float)PI/4*5,10));
    }
    public void addBall(Ball ball){
        balls.add(ball);
    }
    public void removeBall(Ball ball){
        balls.remove(ball);
    }
}
