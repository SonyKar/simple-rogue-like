package Factory;

import components.Door;

import javax.swing.*;
import java.awt.*;

public abstract class RoomFactory extends Factory {
    String title = "";
    Image image = null;
    JPanel content = null;

    public abstract Door generateDoor();
}
