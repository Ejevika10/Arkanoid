import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameField extends JFrame{
    StatisticsBar menuPanel;
    public SettingsFrame settingsFrame;

    AllObjects allObj;
    int width = 1150;
    int height = 800;
    GameField() throws InterruptedException {
        setTitle("Arkanoid");
        width = 1150;
        height = 800;
        setSize(width,height);
        setUndecorated(true);

        allObj = new AllObjects(width,height);
        getContentPane().add(allObj,BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);
        menuPanel = new StatisticsBar();

        getContentPane().add(menuPanel, BorderLayout.NORTH);
        getContentPane().add(Game.menu, BorderLayout.EAST);

        setVisible(true);
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_SPACE) {
                    Game.pause();
                }
                else
                    allObj.activePlatform.key=e;
            }

        });

        switch (Game.settings.size){
            case 1: chSize(800, 600);
            break;
            case 2: chSize(900, 700);
            break;
            case 3:chSize(1150, 800);
            break;
            case 4:chSize(1300,800);
            break;
            case 5:chSize((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight()-50);
            break;
        }

        allObj.gameCicle();
    }
    public void chSize(int width, int height){
        this.width = width;
        this.height = height;
        setSize(new Dimension(width,height));
        allObj.chSize(width,height);
        if (width == (int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth()){
            setExtendedState(Frame.MAXIMIZED_BOTH);
        }
    }
}
