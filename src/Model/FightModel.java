package Model;

public class FightModel {
    Enemy enemy;
    int coins;

    public FightModel(Enemy enemy, int coins) {
        this.enemy = enemy;
        this.coins = coins;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }
}
