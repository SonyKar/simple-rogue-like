package Utilities;

import static main.Main.player;

public abstract class Configuration {
    // init
    public static final int basicHealth = 50;
    public static final int basicDamage = 5;
    public static final int basicLuck = 1;
    public static final int startCoins = 0;

    // Level Up
    public static final int playerHealthPerLevel = 3;
    public static final int playerDamagePerLevel = 1;
    public static final int playerLuckPerLevel = 1;
    public static final int costPerLevel = 3;

    // Fight & Treasure
    public static final int enemyHealthPerLevel = 1;
    public static final int enemyDamagePerLevel = 1;
    public static final int baseMaxGoldFight = 10;
    public static final int multiplier = (player.getLuck() / 10 + 1);
}
