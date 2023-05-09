import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GameMenu extends JFrame{

    MenuItem[] menuItems;

    GameMenu() throws InterruptedException{
        setTitle("Arkanoid");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel(new GridLayout(6, 1, 10, 10));
        panel.setBackground(Color.LIGHT_GRAY);
        JLabel titleLabel = new JLabel("Menu");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        JButton resumeGameButton = new JButton("Resume game");
        JButton newGameButton = new JButton("New game");
        //JButton settingsGameButton = new JButton("Настройки");
        JButton saveGameButton = new JButton("Save game");
        JButton loadGameButton = new JButton("Load game");
        JButton exitButton = new JButton("Exit");

        panel.add(titleLabel);
        panel.add(resumeGameButton);
        panel.add(newGameButton);
        //panel.add(settingsGameButton);
        panel.add(saveGameButton);
        panel.add(loadGameButton);
        panel.add(exitButton);

        // Добавляем панель на окно
        getContentPane().add(panel);

        // Обработка нажатия на кнопки
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                try {
                    Game.start();
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        resumeGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.resume();
            }
        });
        loadGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Game.load();
                } catch (InterruptedException | IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        saveGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.save();
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    public void showMenu(){
        setVisible(true);
        setFocusable(true);
    }
    public void hideMenu(){
        setVisible(false);
        setFocusable(false);
    }
}
