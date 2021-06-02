package engines;

import DAO.playerDB;
import Factory.FightFactory;
import Model.Enemy;
import Model.FightModel;
import frames.Fight;

import static main.Main.login;
import static main.Main.player;

public class FightEngine extends engines.Fight {

    Fight fightGUI;
    FightModel fightModel;
    FightAI fightAI;

    public FightEngine(Fight fightGUI) {
        this.fightGUI = fightGUI;
        this.fightModel = new FightFactory().generateFight();
        fightAI = new FightAI();
    }

    public void makeMove(Element element) {
        String result;
        Enemy enemy = fightModel.getEnemy();

        Element opponentsElement = fightAI.generateMove(4);
        //int randomElementNumber = new Random().nextInt(5);
        //Element opponentsElement = Element.values()[randomElementNumber];

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
                player.setCurrentHealth(player.getCurrentHealth() - enemy.getDamage());
                fightGUI.actualisePlayer(player.getCurrentHealth(), player.getHealth());
                fightGUI.actualisePlayerSelection(playerElementName, false);
                fightGUI.actualiseEnemySelection(opponentsElementName, true);
                result = "player takes damage " + enemy.getDamage() + "\nNow he has " + player.getCurrentHealth();
            }
            else {
                enemy.setCurrentHealth(enemy.getCurrentHealth() - player.getDamage());
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
            player.resetCharacter();
            new playerDB().update(player, login);
            fightGUI.endGame();
        }

        // after round
        fightAI.addPlayerMove(element);
        System.out.println("Result: " + result);
    }

    public FightModel getFightModel() {
        return fightModel;
    }
}
