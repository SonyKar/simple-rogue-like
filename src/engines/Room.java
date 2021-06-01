package engines;

import static main.Main.player;

public class Room{
    public Room() {
        player.setNumberOfVisitedRooms(player.getNumberOfVisitedRooms() + 1);
    }
}
