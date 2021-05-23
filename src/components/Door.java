package components;

import frames.Content;
import frames.Fight;
import main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Door extends Content {


    public Door(String title, Image image, JPanel content) {
        super();

        // JPanel Properties
        setSize(150, 200);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        // Elements
        Padding padding = new Padding(10, 10, 10, 10);

        // Room Icon
        JLabel roomIcon = new JLabel();

        if (image != null) {
            roomIcon.setIcon(new ImageIcon(image));
        }

        GridBagConstraints gridBagConstraints = getGridBagConstraints();

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;

        padding.add(roomIcon, gridBagConstraints);

        // Room Name
        JLabel roomName = new JLabel(title);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 1;

        padding.add(roomName, gridBagConstraints);

        // adding padding

        gridBagConstraints.gridwidth = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;

        add(padding, gridBagConstraints);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Main.gameWindow.changeContent(content, title);
            }
        });
    }
}
