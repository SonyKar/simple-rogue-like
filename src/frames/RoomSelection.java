package frames;

import Factory.RoomFactory;
import components.Padding;

import javax.swing.*;

import java.awt.*;

import static main.Main.gameWindow;
import static main.Main.player;

public class RoomSelection extends Content {
    int distanceBetweenRooms = 5;

    public RoomSelection() {
        super();

        RoomFactory roomFactory = new RoomFactory();

        // Elements

        JButton characterList = new JButton("Character List");
        characterList.addActionListener(e -> gameWindow.changeContent(new CharacterList(), "Character List"));

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;

        add(characterList, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;

        JLabel currentLevel = new JLabel("Level " + player.getNumberOfVisitedRooms());
        currentLevel.setFont(new Font(GameWindow.fontName, Font.BOLD, 40));
        currentLevel.setHorizontalAlignment(JLabel.CENTER);
        add(currentLevel, gridBagConstraints);

        // Setting up doors

        Padding door1 = new Padding(0, distanceBetweenRooms, 0, distanceBetweenRooms);
        Padding door2 = new Padding(0, distanceBetweenRooms, 0, distanceBetweenRooms);
        Padding door3 = new Padding(0, distanceBetweenRooms, 0, distanceBetweenRooms);

        door1.add(roomFactory.generateDoor(RoomFactory.RoomType.TREASURE), gridBagConstraints);
        door2.add(roomFactory.generateDoor(RoomFactory.RoomType.FIGHT), gridBagConstraints);
        door3.add(roomFactory.generateDoor(RoomFactory.RoomType.REST), gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 1;

        add(door1, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 1;

        add(door2, gridBagConstraints);

        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 1;

        add(door3, gridBagConstraints);
    }
}
