import java.awt.*;

public class GameMenu extends DisplayObject{

    MenuItem[] menuItems;

    public GameMenu(int x, int y, int x1, int y1, int width, int height, Color color, int type, boolean movable) {
        super(x, y, x1, y1, width, height, color, type, movable);
    }

    public void addMenuItem(){

    }
    public void deleteMenuItem(){

    }
    public void show(){

    }
    public void hide(){

    }

    @Override
    public void move() {

    }

    @Override
    public boolean checkCollision(DisplayObject obj) {
        return false;
    }

    @Override
    public void draw(Graphics2D g2d) {

    }
}
