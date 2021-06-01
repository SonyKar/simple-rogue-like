package Factory;

import components.Door;
import frames.Treasure;

import javax.swing.*;
import java.awt.*;

public class TreasureRoomFactory extends RoomFactory {
    @Override
    public Door generateDoor() {
        title = "Treasure";
        image = new ImageIcon("src/img/treasure.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        content = new Treasure(generateCoins());
        return new Door(title, image, content);
    }
}
