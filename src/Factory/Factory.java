package Factory;

import Model.Enemy;
import Model.FightModel;
import Utilities.Configuration;
import main.Main;

import java.util.Random;

public class Factory {
    private final String[] enemyNames = new String[] {"Goblin", "Slime", "Bat", "Skeleton", "Wizard", "Ghost", "Zombie", "Rat", "Vampire", "Wolf", "Thug"};
    private final Random random = new Random();

    private Enemy generateEnemy() {
        String enemyName = enemyNames[random.nextInt(enemyNames.length)];
        int enemyDamage = random.nextInt(Main.player.getLevel() * Configuration.enemyDamagePerLevel + 2) + 1;
        int enemyHealth = random.nextInt(Main.player.getLevel() * Configuration.enemyHealthPerLevel + 10) + 5;

        return new Enemy(enemyName, enemyHealth, enemyDamage);
    }

    public FightModel generateFight() {
        Enemy enemy = generateEnemy();
        int coins = random.nextInt(Configuration.baseMaxGoldFight * Configuration.multiplier) + 1;

        return new FightModel(enemy, coins);
    }
}
