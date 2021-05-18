package Model;

public class Player extends Entity {
    int level;
    int luck;
    int coins;

    public Player(String name, int health, int damage, int luck, int coins) {
        super(name, health, damage);
        this.luck = luck;
        this.coins = coins;
        this.level = luck + damage / 5 + health / 10 - 5 - 1;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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
