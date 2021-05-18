package frames;

import components.Door;
import components.Padding;

import javax.swing.*;
import java.awt.*;

public class RoomSelection extends JPanel {
    int distanceBetweenRooms = 5;

    public RoomSelection() {
        // JPanel Properties
        setLayout(new GridBagLayout());

        // GridBagLayout properties
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;

        // Elements

        // Setting up doors

        Padding door1 = new Padding(0, distanceBetweenRooms, 0, distanceBetweenRooms);
        Padding door2 = new Padding(0, distanceBetweenRooms, 0, distanceBetweenRooms);
        Padding door3 = new Padding(0, distanceBetweenRooms, 0, distanceBetweenRooms);

        door1.add(new Door(), gridBagConstraints);
        door2.add(new Door(), gridBagConstraints);
        door3.add(new Door(), gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;

        add(door1, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;

        add(door2, gridBagConstraints);

        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;

        add(door3, gridBagConstraints);
    }
}
