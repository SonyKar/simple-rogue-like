package engines;

import Model.Enemy;
import Model.FightModel;
import controllers.EnemyController;
import controllers.PlayerController;
import frames.Fight;

import static main.Main.player;

public class FightEngine extends engines.Fight {

    Fight fightGUI;
    FightModel fightModel;
    PlayerController playerController;
    EnemyController enemyController;
    FightAI fightAI;

    public FightEngine(Fight fightGUI, FightModel fightModel) {
        this.fightGUI = fightGUI;
        this.fightModel = fightModel;
        playerController = new PlayerController(player);
        enemyController = new EnemyController(fightModel.getEnemy());
        fightAI = new FightAI();
    }

    public void makeMove(Element element) {
        String result;
        Enemy enemy = fightModel.getEnemy();

        //int randomElementNumber = new Random().nextInt(5);
        Element opponentsElement = fightAI.generateMove(4);

        String playerElementName = element.toString().charAt(0) + element.toString().toLowerCase().substring(1);
        String opponentsElementName = opponentsElement.toString().charAt(0) + opponentsElement.toString().toLowerCase().substring(1);

        if (element == opponentsElement) {
            fightGUI.actualisePlayerSelection(playerElementName, true);
            fightGUI.actualiseEnemySelection(opponentsElementName, true);
            result = "Draw";
        }
        else {
            Element[] weaknesses = rules.get(element);
            if (opponentsElement == weaknesses[0] || opponentsElement == weaknesses[1]) {
                //playerController.takeDamage(enemy.getDamage());
                fightGUI.actualisePlayer(player.getCurrentHealth(), player.getHealth());
                fightGUI.actualisePlayerSelection(playerElementName, false);
                fightGUI.actualiseEnemySelection(opponentsElementName, true);
                result = "player takes damage " + enemy.getDamage() + "\nNow he has " + player.getCurrentHealth();
            }
            else {
                //enemyController.takeDamage(player.getDamage());
                fightGUI.actualiseEnemy(enemy.getCurrentHealth(), enemy.getHealth());
                fightGUI.actualisePlayerSelection(playerElementName, true);
                fightGUI.actualiseEnemySelection(opponentsElementName, false);
                result = "enemy takes damage " + player.getDamage() + "\nNow it has " + enemy.getCurrentHealth();
            }
        }

        if (enemy.getCurrentHealth() <= 0) {
            System.out.println("You Win!");
            System.out.println("You earned " + fightModel.getCoins() + " coins");
            fightGUI.leaveRoom(fightModel.getCoins());
        }

        if (player.getCurrentHealth() <= 0) {
            System.out.println("You Died!");
            System.exit(1);
        }

        // after round
        fightAI.addPlayerMove(element);
        System.out.println("Result: " + result);
    }

    public FightModel getFightModel() {
        return fightModel;
    }
}
