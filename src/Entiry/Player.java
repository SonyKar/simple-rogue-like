package Entiry;

public class Player extends Entity {
    int luck;
    int coins;

    public Player(String name, int health, int damage, int luck, int coins) {
        super(name, health, damage);
        this.luck = luck;
        this.coins = coins;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }
}
