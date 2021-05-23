package Factory;

import components.Door;
import frames.Fight;
import frames.Rest;

import javax.swing.*;
import java.awt.*;

public class RoomFactory {
    public enum RoomType {
        FIGHT,
        VOID,
        TREASURE,
        REST
    }

    public Door generateDoor(RoomType roomType) {
        String title = "";
        Image image = null;
        JPanel content = null;

        switch (roomType) {
            case FIGHT -> {
                title = "Fight";
                image = new ImageIcon("src/img/fight.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
                content = new Fight();
            }
            case VOID -> {
                title = "Void";
                image = new ImageIcon("src/img/fight.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
            }
            case TREASURE -> {
                title = "Treasure";
                image = new ImageIcon("src/img/fight.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
            }
            case REST -> {
                title = "Rest";
                image = new ImageIcon("src/img/rest.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
                content = new Rest();
            }
        }

        return new Door(title, image, content);
    }
}
