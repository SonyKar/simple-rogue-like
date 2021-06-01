package Factory;

import components.Door;
import frames.Fight;

import javax.swing.*;
import java.awt.*;

public class FightRoomFactory extends RoomFactory {

    @Override
    public Door generateDoor() {
        title = "Fight";
        image = new ImageIcon("src/img/fight.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        content = new Fight();
        return new Door(title, image, content);
    }
}
