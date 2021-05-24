package Factory;

import Model.Enemy;
import Model.FightModel;
import Utilities.Configuration;

import static main.Main.player;

public class FightFactory extends Factory {
    private final String[] enemyNames = new String[] {"Goblin", "Slime", "Bat", "Skeleton", "Wizard", "Ghost", "Zombie", "Rat", "Vampire", "Wolf", "Thug"};

    private Enemy generateEnemy() {
        String enemyName = enemyNames[random.nextInt(enemyNames.length)];
        int enemyDamage = random.nextInt(player.getNumberOfVisitedRooms() * Configuration.enemyDamagePerLevel + 2) + 1;
        int enemyHealth = random.nextInt(player.getNumberOfVisitedRooms() * Configuration.enemyHealthPerLevel + 10) + 5;

        return new Enemy(enemyName, enemyHealth, enemyDamage);
    }

    public FightModel generateFight() {
        Enemy enemy = generateEnemy();
        int coins = generateCoins();

        return new FightModel(enemy, coins);
    }
}
