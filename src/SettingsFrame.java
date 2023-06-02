import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsFrame extends JFrame {

    private final Settings settings;

    public SettingsFrame(Settings settings) {
        super("Settings");
        this.settings = settings;

        JRadioButton hard1Button = new JRadioButton("1",null,false);
        JRadioButton hard2Button = new JRadioButton("2",null,false);
        JRadioButton hard3Button = new JRadioButton("3",null,false);
        JRadioButton hard4Button = new JRadioButton("4",null,false);
        JRadioButton hard5Button = new JRadioButton("5",null,false);

        ButtonGroup groupHard = new ButtonGroup();
        groupHard.add(hard1Button);
        groupHard.add(hard2Button);
        groupHard.add(hard3Button);
        groupHard.add(hard4Button);
        groupHard.add(hard5Button);

        JRadioButton size1Button = new JRadioButton("1",null,false);
        JRadioButton size2Button = new JRadioButton("2",null,false);
        JRadioButton size3Button = new JRadioButton("3",null,false);
        JRadioButton size4Button = new JRadioButton("4",null,false);
        JRadioButton size5Button = new JRadioButton("5",null,false);

        ButtonGroup groupSize = new ButtonGroup();
        groupSize.add(size1Button);
        groupSize.add(size2Button);
        groupSize.add(size3Button);
        groupSize.add(size4Button);
        groupSize.add(size5Button);

        // create apply button
        JButton applyButton = new JButton("Apply");
        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // save settings
                if (hard1Button.isSelected()){
                    settings.difficulty = 0;
                    Game.players.players[0].balls.balls.get(0).speed = 6;
                }
                else if (hard2Button.isSelected()) {
                    settings.difficulty = 1;
                    Game.players.players[0].balls.balls.get(0).speed = 8;
                }
                else if (hard3Button.isSelected()) {
                    settings.difficulty = 2;
                    Game.players.players[0].balls.balls.get(0).speed = 10;
                }
                else if (hard4Button.isSelected()) {
                    settings.difficulty = 3;
                    Game.players.players[0].balls.balls.get(0).speed = 12;
                }
                else if (hard5Button.isSelected()) {
                    settings.difficulty = 4;
                    Game.players.players[0].balls.balls.get(0).speed = 14;
                }
                if (size1Button.isSelected()){
                    Game.gameField.chSize(800, 600);
                    settings.size = 1;
                }
                else if (size2Button.isSelected()) {
                    Game.gameField.chSize(900, 700);
                    settings.size = 2;
                }
                else if (size3Button.isSelected()){
                    Game.gameField.chSize(1150, 800);
                    settings.size = 3;
                }
                else if (size4Button.isSelected()) {
                    Game.gameField.chSize(1300, 800);
                    settings.size = 4;
                }
                else if (size5Button.isSelected()){
                    Game.gameField.chSize((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight()-50);
                    settings.size = 5;
                }
                    // close settings window
                dispose();
            }
        });

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 15, 5, 15);
        c.gridx = 0;
        c.gridy = 0;
        panel.add(new JLabel("Difficulty"), c);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(hard1Button, c);
        c.gridx = 0;
        c.gridy = 2;
        panel.add(hard2Button, c);
        c.gridx = 0;
        c.gridy = 3;
        panel.add(hard3Button, c);
        c.gridx = 0;
        c.gridy = 4;
        panel.add(hard4Button, c);
        c.gridx = 0;
        c.gridy = 5;
        panel.add(hard5Button, c);

        c.gridx = 1;
        c.gridy = 0;
        panel.add(new JLabel("Size"), c);
        c.gridx = 1;
        c.gridy = 1;
        panel.add(size1Button, c);
        c.gridx = 1;
        c.gridy = 2;
        panel.add(size2Button, c);
        c.gridx = 1;
        c.gridy = 3;
        panel.add(size3Button, c);
        c.gridx = 1;
        c.gridy = 4;
        panel.add(size4Button, c);
        c.gridx = 1;
        c.gridy = 5;
        panel.add(size5Button, c);

        c.gridx = 0;
        c.gridy = 6;

        panel.add(applyButton, c);

        setContentPane(panel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}
