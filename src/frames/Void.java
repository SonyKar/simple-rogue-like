package frames;

import javax.swing.*;
import java.awt.*;

import static main.Main.gameWindow;
import static main.Main.player;

public class Void extends JPanel {
    public Void() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel header = new JLabel("Void");
        header.setFont(new Font(GameWindow.fontName, Font.BOLD, 40));

        JLabel text = new JLabel("You found a dark empty corridor, which ends in 3 doors");

        JButton nextButton = new JButton("Select a door");
        nextButton.addActionListener(e -> {
            player.setNumberOfVisitedRooms(player.getNumberOfVisitedRooms() + 1);
            gameWindow.changeContent(new RoomSelection(), "Select a Room");
        });

        add(header);
        add(text);
        add(nextButton);
    }
}
