import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatisticsBar extends JPanel {
    static JLabel stat;

    JButton menuButton;

    StatisticsBar(){
        setBounds(0,0,1015,50);
        stat = new JLabel(Game.players.getFullStatistic());
        menuButton = new JButton("Menu");
        add(stat,BorderLayout.WEST);
        add(menuButton, BorderLayout.EAST);
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transferFocusDownCycle();
                Game.pause();
            }
        });
    }
    public static void updStat(){
        stat.setText(Game.players.getFullStatistic());
    }

}
