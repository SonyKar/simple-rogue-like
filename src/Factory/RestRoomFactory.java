package Factory;

import components.Door;
import frames.Rest;

import javax.swing.*;
import java.awt.*;

public class RestRoomFactory extends RoomFactory {
    @Override
    public Door generateDoor() {
        title = "Rest";
        image = new ImageIcon("src/img/rest.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        content = new Rest();
        return new Door(title, image, content);
    }
}
