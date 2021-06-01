package engines;

import static main.Main.player;

public class TreasureRoom {
    int coins;

    public TreasureRoom(int coins) {
        this.coins = coins;
    }

    public void collectCoins() {
        player.setCoins(player.getCoins() + coins);
        player.setNumberOfVisitedRooms(player.getNumberOfVisitedRooms() + 1);
    }
}