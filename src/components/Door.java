package components;

import javax.swing.*;
import java.awt.*;

public class Door extends JPanel {
    public Door() {
        // JPanel Properties
        setLayout(new GridBagLayout());
        setSize(150, 200);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        // GridBagLayout properties
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;

        // Elements
        Padding padding = new Padding(10, 10, 10, 10);

        // Room Icon
        JLabel roomIcon = new JLabel();

        Image image = new ImageIcon("src/img/fight.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        roomIcon.setIcon(new ImageIcon(image));

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;

        padding.add(roomIcon, gridBagConstraints);

        // Room Name
        JLabel roomName = new JLabel("Some Text");

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 1;

        padding.add(roomName, gridBagConstraints);

        // adding padding

        gridBagConstraints.gridwidth = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;

        add(padding, gridBagConstraints);
    }
}
