import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMessage extends JFrame {
    public JLabel label;
    public JButton btn;

    GameMessage(String lbl){
        setTitle("Arkanoid");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        panel.setBackground(Color.LIGHT_GRAY);
        this.label = new JLabel(lbl);
        this.label.setFont(new Font("Arial", Font.BOLD, 24));
        this.label.setHorizontalAlignment(JLabel.CENTER);
        this.btn = new JButton("Ok");

        panel.add(label);
        panel.add(btn);



        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hideMsg();
            }
        });
        getContentPane().add(panel);

    }

    public void showMsg(){
        setVisible(true);
        setFocusable(true);
    }
    public void hideMsg(){
        setVisible(false);
        setFocusable(false);
        Game.menu.showMenu();
    }
}
