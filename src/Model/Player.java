package Model;

public class Player extends Entity {
    int numberOfVisitedRooms;
    int characteristicLevel;
    int luck;
    int coins;

    public Player(String name, int health, int damage, int luck, int coins) {
        super(name, health, damage);
        this.luck = luck;
        this.coins = coins;
        this.characteristicLevel = luck + damage / 5 + health / 10 - 5 - 1;
    }

    public int getCharacteristicLevel() {
        return characteristicLevel;
    }

    public void setCharacteristicLevel(int characteristicLevel) {
        this.characteristicLevel = characteristicLevel;
    }

    public int getNumberOfVisitedRooms() {
        return numberOfVisitedRooms;
    }

    public void setNumberOfVisitedRooms(int numberOfVisitedRooms) {
        this.numberOfVisitedRooms = numberOfVisitedRooms;
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
