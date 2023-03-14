import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class AllObjects extends JPanel{
    DisplayObject[] allObj;
    int pos = 0;

    AllObjects()
    {
        allObj = new DisplayObject[23];
        Blocks objects = new Blocks();
        addObj(objects.blocks);
        Platforms platform = new Platforms();
        addObj(platform.platforms);
        Balls balls= new Balls();
        addObj(balls.balls);
    }
    public void addObj(DisplayObject obj[]){
        for (DisplayObject block:obj)
        {
            allObj[pos] = block;
            pos++;
        }
    }

    public void gameCicle() throws InterruptedException {}
    public void deleteObj(DisplayObject obj[]){}


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setBackground(Color.LIGHT_GRAY);
        g2d.clearRect(0, 0, getParent().getWidth(), getParent().getHeight());

        for (DisplayObject object:allObj) {
            object.draw(g2d);
        }
    }
}
