import java.awt.*;

import static java.lang.Math.PI;

public class Balls {
    public Ball[] balls;
    int pos = 0;
    Balls(){
        balls = new Ball[1];
        addBall(new Ball(500,685,15,Color.RED.getRed(),Color.RED.getGreen(), Color.RED.getBlue(),(float)PI/4*5,15));
    }
    void addBall(Ball ball){
        balls[pos] = ball;
    }
}
