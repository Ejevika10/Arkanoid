import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsFrame extends JFrame {

    private final Settings settings;

    public SettingsFrame(Settings settings) {
        super("Настройки");
        this.settings = settings;

        JRadioButton easyButton = new JRadioButton("Easy",null,false);
        JRadioButton mediumButton = new JRadioButton("Medium",null,false);
        JRadioButton hardButton = new JRadioButton("Hard",null,false);

        ButtonGroup groupHard = new ButtonGroup();
        groupHard.add(easyButton);
        groupHard.add(mediumButton);
        groupHard.add(hardButton);

        JRadioButton minButton = new JRadioButton("Min",null,false);
        JRadioButton midButton = new JRadioButton("Medium",null,false);
        JRadioButton maxButton = new JRadioButton("Max",null,false);

        ButtonGroup groupSize = new ButtonGroup();
        groupSize.add(minButton);
        groupSize.add(midButton);
        groupSize.add(maxButton);

        // create apply button
        JButton applyButton = new JButton("Apply");
        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // save settings
                if (easyButton.isSelected())
                    settings.difficulty = 0;
                else if (mediumButton.isSelected())
                    settings.difficulty = 1;
                else if (hardButton.isSelected())
                    settings.difficulty = 2;
                for (DisplayObject object: Game.gameField.allObj.allObj) {
                    if (object instanceof Platform) {
                        ((Platform) object).changeWidth(settings.difficulty);
                    }
                }

                if (minButton.isSelected()){
                    Game.gameField.chSize(800, 600);
                    settings.size = 1;
                }
                else if (mediumButton.isSelected()) {
                    Game.gameField.chSize(1150, 800);
                    settings.size = 2;
                }
                else if (hardButton.isSelected()){
                    Game.gameField.chSize((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight()-50);
                    settings.size = 3;
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
        panel.add(new JLabel("Сложность"), c);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(easyButton, c);
        c.gridx = 0;
        c.gridy = 2;
        panel.add(mediumButton, c);
        c.gridx = 0;
        c.gridy = 3;
        panel.add(hardButton, c);

        c.gridx = 1;
        c.gridy = 0;
        panel.add(new JLabel("Размер экрана"), c);
        c.gridx = 1;
        c.gridy = 1;
        panel.add(minButton, c);
        c.gridx = 1;
        c.gridy = 2;
        panel.add(midButton, c);
        c.gridx = 1;
        c.gridy = 3;
        panel.add(maxButton, c);
        c.gridx = 0;
        c.gridy = 4;


        panel.add(applyButton, c);

        setContentPane(panel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}
