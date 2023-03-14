import java.awt.*;

public class Balls {
    public Ball[] balls;
    int pos = 0;
    Balls(){
        balls = new Ball[1];
        addBall(new Ball(200,240,230,270,30,30, Color.RED,1,true,15,0));
    }
    void addBall(Ball ball){
        balls[pos] = ball;
    }
}
