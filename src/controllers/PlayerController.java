package controllers;

import Model.Player;

public class PlayerController extends EntityController {

    public PlayerController(Player player) {
        super(player);
    }

    public void collectCoins(int coins) {
        Player player = ((Player)entity);
        player.setCoins(player.getCoins() + coins);
    }

    public void incrementRooms() {
        Player player = ((Player)entity);
        player.setNumberOfVisitedRooms(player.getNumberOfVisitedRooms() + 1);
    }
}
