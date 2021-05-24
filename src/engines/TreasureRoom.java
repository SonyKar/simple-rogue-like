package engines;

import controllers.PlayerController;

import static main.Main.player;

public class TreasureRoom {
    int coins;

    public TreasureRoom(int coins) {
        this.coins = coins;
    }

    public void collectCoins() {
        PlayerController playerController = new PlayerController(player);
        playerController.collectCoins(coins);
        playerController.incrementRooms();
    }
}
