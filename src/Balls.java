import java.awt.*;

import static java.lang.Math.PI;

public class Balls {
    public Ball[] balls;
    //int pos = 0;
    Balls(int width, int height){
        balls = new Ball[1];
        addBall(new Ball((width - 135)/2, height - 115, 15,Color.RED.getRed(),Color.RED.getGreen(), Color.RED.getBlue(),(float)PI/4*5,10));
    }
    void addBall(Ball ball){
        balls[0] = ball;
    }
}
