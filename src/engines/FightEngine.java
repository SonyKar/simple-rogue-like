package engines;

import Model.Enemy;
import Model.FightModel;
import controllers.EnemyController;
import controllers.PlayerController;
import frames.Fight;

import java.util.HashMap;
import java.util.Random;

import static main.Main.player;

/*
 * Fire -> Wood
 * Fire -> Metal
 * Earth -> Fire
 * Earth -> Water
 * Metal -> Earth
 * Metal -> Wood
 * Water -> Metal
 * Water -> Fire
 * Wood -> Water
 * Wood -> Earth
 */

public class FightEngine {
    public enum Element {
        FIRE, // 0
        WOOD, // 1
        METAL, // 2
        WATER, // 3
        EARTH // 4
    }

    Fight fightGUI;
    FightModel fightModel;
    PlayerController playerController;
    EnemyController enemyController;

    // strategy
    private static final HashMap<Element, Element[]> rules = new HashMap<>() {{
        put(Element.FIRE, new Element[]{Element.WOOD, Element.METAL});
        put(Element.EARTH, new Element[]{Element.FIRE, Element.WATER});
        put(Element.METAL, new Element[]{Element.EARTH, Element.WOOD});
        put(Element.WATER, new Element[]{Element.FIRE, Element.METAL});
        put(Element.WOOD, new Element[]{Element.WATER, Element.EARTH});
    }};

    public FightEngine(Fight fightGUI, FightModel fightModel) {
        this.fightGUI = fightGUI;
        this.fightModel = fightModel;
        playerController = new PlayerController(player);
        enemyController = new EnemyController(fightModel.getEnemy());
    }

    public void makeMove(Element element) {
        String result;
        Enemy enemy = fightModel.getEnemy();

        int randomElementNumber = new Random().nextInt(5);
        Element opponentsElement = Element.values()[randomElementNumber];

        if (element == opponentsElement) result = "Draw";
        else {
            Element[] weaknesses = rules.get(element);
            if (opponentsElement == weaknesses[0] || opponentsElement == weaknesses[1]) {
                enemyController.takeDamage(player.getDamage());
                fightGUI.actualiseEnemy(enemy.getCurrentHealth(), enemy.getHealth());
                result = "enemy takes damage " + player.getDamage() + "\nNow it has " + enemy.getCurrentHealth();
            }
            else {
                playerController.takeDamage(enemy.getDamage());
                fightGUI.actualisePlayer(player.getCurrentHealth(), player.getHealth());
                result = "player takes damage " + enemy.getDamage() + "\nNow he has " + player.getCurrentHealth();
            }
        }

        if (enemy.getCurrentHealth() <= 0) {
            playerController.collectCoins(fightModel.getCoins());
            System.out.println("You Win!");
            System.out.println("You earned " + fightModel.getCoins() + " coins");
            fightGUI.endFight();
        }

        if (player.getCurrentHealth() <= 0) {
            System.out.println("You Died!");
            System.exit(1);
        }

        System.out.println("Result: " + result);
    }

    public FightModel getFightModel() {
        return fightModel;
    }
}
