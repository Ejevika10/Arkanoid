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
        setSize(1015, 800);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel(new GridLayout(6, 3, 10, 50));
        panel.setBackground(Color.LIGHT_GRAY);
        JLabel titleLabel = new JLabel("Menu");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        JButton[] but = new JButton[5];
        but[0] = new JButton("Resume game");
        but[1] = new JButton("New game");
        but[2] = new JButton("Save game");
        but[3] = new JButton("Load game");
        but[4] = new JButton("Exit");

        // Добавляем элементы на панель
        JLabel Label = new JLabel(" ");
        panel.add(Label);
        panel.add(titleLabel);
        JLabel Label1 = new JLabel(" ");
        panel.add(Label1);
        for (int i = 0; i < 5; i++){
            JLabel Label2 = new JLabel(" ");
            panel.add(Label2);
            panel.add(but[i]);
            JLabel Label3 = new JLabel(" ");
            panel.add(Label3);
        }

        // Добавляем панель на окно
        getContentPane().add(panel);

        // Обработка нажатия на кнопки
        but[1].addActionListener(new ActionListener() {
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
        but[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.resume();
            }
        });
        but[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Game.load();
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        but[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.save();
            }
        });
        but[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    public void showMenu(){
        setVisible(true);
    }
    public void hideMenu(){
        setVisible(false);
    }
}
