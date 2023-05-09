import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameField extends JFrame{
    StatisticsBar menuPanel;
    AllObjects allObj;
    GameField() throws InterruptedException {
        setTitle("Arkanoid");
        allObj = new AllObjects();
        getContentPane().add(allObj,BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1015, 800);
        setLocationRelativeTo(null);
        menuPanel = new StatisticsBar();

        getContentPane().add(menuPanel, BorderLayout.NORTH);
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

        allObj.gameCicle();
    }
    public void сheckGameState(){

    }
}
