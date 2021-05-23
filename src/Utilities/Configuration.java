package Utilities;

import static main.Main.player;

public abstract class Configuration {
    // Level Up
    public static final int playerHealthPerLevel = 3;
    public static final int playerDamagePerLevel = 1;
    public static final int playerLuckPerLevel = 1;
    public static final int costPerLevel = 3;

    // Fight & Treasure
    public static final int enemyHealthPerLevel = 5;
    public static final int enemyDamagePerLevel = 2;
    public static final int baseMaxGoldFight = 10;
    public static final int multiplier = (player.getLuck() / 10 + 1);
}
