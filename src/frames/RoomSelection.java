package frames;

import Factory.*;
import components.Padding;

import javax.swing.*;

import java.awt.*;
import java.util.Random;

import static main.Main.gameWindow;
import static main.Main.player;

public class RoomSelection extends Content {
    private final RoomFactory[] rooms = new RoomFactory[]{new FightRoomFactory(), new RestRoomFactory(), new TreasureRoomFactory(), new VoidRoomFactory()};

    public RoomSelection() {
        super();

        // Elements

        JButton characterList = new JButton("Character List");
        characterList.addActionListener(e -> new CharacterList());

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

        int distanceBetweenRooms = 5;
        Padding door1 = new Padding(0, distanceBetweenRooms, 0, distanceBetweenRooms);
        Padding door2 = new Padding(0, distanceBetweenRooms, 0, distanceBetweenRooms);
        Padding door3 = new Padding(0, distanceBetweenRooms, 0, distanceBetweenRooms);

        Random random = new Random();
        door1.add(rooms[random.nextInt(rooms.length)].generateDoor(), gridBagConstraints);
        door2.add(rooms[random.nextInt(rooms.length)].generateDoor(), gridBagConstraints);
        door3.add(rooms[random.nextInt(rooms.length)].generateDoor(), gridBagConstraints);

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
