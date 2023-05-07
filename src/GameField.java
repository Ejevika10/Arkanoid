import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameField extends JFrame{
    AllObjects allObj;
    GameField() throws InterruptedException {
        setTitle("Arkanoid");
        allObj = new AllObjects();
        getContentPane().add(allObj,BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1015, 800);
        setLocationRelativeTo(null);
        JPanel menuPanel = new JPanel(new BorderLayout());
        menuPanel.setBounds(0,0,1015,50);
        JButton menuButton = new JButton("Menu");
        menuPanel.add(menuButton, BorderLayout.EAST);
        getContentPane().add(menuPanel, BorderLayout.NORTH);
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Game.pause();
            }
        });
        setVisible(true);
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                allObj.activePlatform.key=e;
            }

        });
        allObj.gameCicle();
    }
    public void сheckGameState(){

    }
}
