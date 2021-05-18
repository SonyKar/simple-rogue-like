package Utilities;

import main.Main;

public abstract class Configuration {
    public static final int enemyHealthPerLevel = 5;
    public static final int enemyDamagePerLevel = 2;
    public static final int baseMaxGoldFight = 10;
    public static final int multiplier = (Main.player.getLuck() / 10 + 1);
}
