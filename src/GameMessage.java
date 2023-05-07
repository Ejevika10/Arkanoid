import java.awt.*;

public class GameMessage extends DisplayObject {
    private String message;

    public GameMessage(int x, int y, int x1, int y1, int x2, int y2, int width, int height, Color color, int type, int movable, int visible) {
        //super(x, y, x1, y1, x2, y2, width, height, color, type, movable, visible);
    }


    public void setMessage(String message) {
        this.message = message;
    }

    public void show(){

    }
    public void hide(){

    }

    @Override
    public void move() {

    }
    @Override
    public void changeDirection(int i) {

    }
    @Override
    public void draw(Graphics2D g2d) {

    }




}
