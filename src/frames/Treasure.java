package frames;

import controllers.PlayerController;

import javax.swing.*;
import java.awt.*;

import static main.Main.gameWindow;
import static main.Main.player;

public class Treasure extends JPanel {

    public Treasure(int coins) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel header = new JLabel("Treasury");
        header.setFont(new Font(GameWindow.fontName, Font.BOLD, 40));

        JLabel text = new JLabel("You found " + coins + " coins in the chest");

        JButton nextButton = new JButton("Go forward");
        nextButton.addActionListener(e -> {
            PlayerController playerController = new PlayerController(player);
            playerController.collectCoins(coins);
            playerController.incrementRooms();
            gameWindow.changeContent(new RoomSelection(), "Select a Room");
        });

        add(header);
        add(text);
        add(nextButton);
    }
}
