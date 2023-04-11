import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

public class AllObjects extends JPanel{
    DisplayObject[] allObj;
    Platform activePlatform;
    int pos = 0;

    AllObjects()
    {
        allObj = new DisplayObject[29];
        Blocks objects = new Blocks();
        addObj(objects.blocks);
        Platforms platform = new Platforms();
        activePlatform = platform.platforms[0];
        addObj(platform.platforms);
        Balls balls= new Balls();
        addObj(balls.balls);
        setFocusable(true);
        requestFocusInWindow();
    }
    public void addObj(DisplayObject obj[]){
        for (DisplayObject block:obj)
        {
            allObj[pos] = block;
            pos++;
        }
    }

    public void gameCicle() throws InterruptedException {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                activePlatform.key=e;
            }

        });
        while (true)
        {
            for (DisplayObject obj: allObj)
            {
                if (obj.movable == 1)
                {
                    obj.move();
                    for (DisplayObject obj2: allObj)
                    {
                        if (!obj.equals(obj2) && obj2.visible == 1)
                            if (obj.checkCollision(obj2)){
                                if (obj2.getClass().toString().equals("class Block")) {
                                    Block block = (Block) obj2;
                                    block.setHardness(block.getHardness() - 1);
                                    switch (block.getHardness()) {
                                        case 1 -> block.setColor(Color.BLUE);
                                        case 2 -> block.setColor(Color.CYAN);
                                    }
                                }
                                break;
                            }
                    }
                }
            }
            this.repaint();
            Thread.sleep(15);
        }
    }
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
