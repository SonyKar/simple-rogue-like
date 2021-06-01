package Factory;

import components.Door;
import frames.Void;

import javax.swing.*;
import java.awt.*;

public class VoidRoomFactory extends RoomFactory {

    @Override
    public Door generateDoor() {
        title = "Void";
        image = new ImageIcon("src/img/void.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        content = new Void();
        return new Door(title, image, content);
    }
}
