import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GameMenu extends JPanel{
    JPanel menuPanel;

    MenuItem[] menuItems;

    GameMenu() throws InterruptedException{

        menuPanel = new JPanel(new GridBagLayout());
        menuPanel.setVisible(false);
        setPreferredSize(new Dimension(125,500));
        //setBackground(Color.LIGHT_GRAY);
        JLabel titleLabel = new JLabel("Menu");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        JButton resumeGameButton = new JButton("Resume game");
        JButton newGameButton = new JButton("New game");
        JButton saveGameButton = new JButton("Save game");
        JButton loadJsonGameButton = new JButton("Load json");
        JButton loadTxtGameButton = new JButton("Load txt");
        JButton settingsGameButton = new JButton("Settings");
        JButton exitButton = new JButton("Exit");

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(5, 5, 5, 5);
        menuPanel.add(titleLabel, c);
        c.gridx = 1;
        c.gridy = 1;
        menuPanel.add(resumeGameButton, c);
        c.gridx = 1;
        c.gridy = 2;
        menuPanel.add(newGameButton, c);
        c.gridx = 1;
        c.gridy = 3;
        menuPanel.add(saveGameButton, c);
        c.gridx = 1;
        c.gridy = 4;
        menuPanel.add(loadJsonGameButton, c);
        c.gridx = 1;
        c.gridy = 5;
        menuPanel.add(loadTxtGameButton, c);
        c.gridx = 1;
        c.gridy = 6;
        menuPanel.add(settingsGameButton, c);
        c.gridx = 1;
        c.gridy = 6;
        menuPanel.add(exitButton, c);
        add(menuPanel);
        // Обработка нажатия на кнопки
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.gameField.dispose();
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
        loadJsonGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Game.loadJson();
                } catch (InterruptedException | IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        loadTxtGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Game.loadTxt();
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
        settingsGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.settings.settingsFrame = new SettingsFrame(Game.settings);
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        setVisible(true);
    }
    public void showMenu(){
        menuPanel.setVisible(true);
        setFocusable(true);
        //Game.gameField.
        //super.paintComponent();
    }
    public void hideMenu(){
        menuPanel.setVisible(false);
        setFocusable(false);
    }
}
