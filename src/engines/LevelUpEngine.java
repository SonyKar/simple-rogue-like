package engines;

import Utilities.Configuration;
import components.Characteristic;
import controllers.PlayerController;
import frames.Rest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.Main.player;

public class LevelUpEngine {
    Rest restGui;
    int tmpHealth = player.getHealth(), tmpDamage = player.getDamage(), tmpLuck = player.getLuck();
    int leftCoin = player.getCoins();
    int playerFutureLevel = player.getCharacteristicLevel();

    public LevelUpEngine(Rest restGui) {
        this.restGui = restGui;

        restGui.actualizePurse(player.getCoins());
        restGui.actualizeCostPerLevel(player.getCharacteristicLevel() * Configuration.costPerLevel);

        checkLevelUpAvailability();
    }

    private void checkLevelUpAvailability() {
        if (leftCoin < playerFutureLevel * Configuration.costPerLevel) {
            restGui.getHealth().disablePlusButton();
            restGui.getDamage().disablePlusButton();
            restGui.getLuck().disablePlusButton();
        } else {
            restGui.getHealth().enablePlusButton();
            restGui.getDamage().enablePlusButton();
            restGui.getLuck().enablePlusButton();
        }
    }

    private void downGradeAvailableHandler(int tmp, int actual, Characteristic characteristic) {
        if (tmp > actual) {
            characteristic.enableMinusButton();
        } else {
            characteristic.disableMinusButton();
        }
    }
    private void checkDownGradeAvailability() {
        downGradeAvailableHandler(tmpHealth, player.getHealth(), restGui.getHealth());
        downGradeAvailableHandler(tmpDamage, player.getDamage(), restGui.getDamage());
        downGradeAvailableHandler(tmpLuck, player.getLuck(), restGui.getLuck());
    }

    private void levelUpButtons(boolean isLevelUp) {
        int levelCost;
        if (isLevelUp) {
            levelCost = playerFutureLevel * Configuration.costPerLevel;
            playerFutureLevel++;
            leftCoin -= levelCost;
        } else {
            playerFutureLevel--;
            levelCost = playerFutureLevel * Configuration.costPerLevel;
            leftCoin += levelCost;
        }
        restGui.actualizePurse(leftCoin);
        restGui.actualizeCostPerLevel(playerFutureLevel * Configuration.costPerLevel);
        checkLevelUpAvailability();
        checkDownGradeAvailability();
    }

    // Ок ли иметь много одинаковых функций, потому что я не хочу обращаться к графике, чтобы вытаскивать информацию
    public ActionListener healthLevelUp = e -> {
        tmpHealth += Configuration.playerHealthPerLevel;
        restGui.getHealth().actualizeCurrentValue(tmpHealth);
        levelUpButtons(true);
    };

    public ActionListener healthDownGrade = e -> {
        tmpHealth -= Configuration.playerHealthPerLevel;
        restGui.getHealth().actualizeCurrentValue(tmpHealth);
        levelUpButtons(false);
    };

    public ActionListener damageLevelUp = e -> {
        tmpDamage += Configuration.playerDamagePerLevel;
        restGui.getDamage().actualizeCurrentValue(tmpDamage);
        levelUpButtons(true);
    };

    public ActionListener damageDownGrade = e -> {
        tmpDamage -= Configuration.playerDamagePerLevel;
        restGui.getDamage().actualizeCurrentValue(tmpDamage);
        levelUpButtons(false);
    };

    public ActionListener luckLevelUp = e -> {
        tmpLuck += Configuration.playerLuckPerLevel;
        restGui.getLuck().actualizeCurrentValue(tmpLuck);
        levelUpButtons(true);
    };

    public ActionListener luckDownGrade = e -> {
        tmpLuck -= Configuration.playerLuckPerLevel;
        restGui.getLuck().actualizeCurrentValue(tmpLuck);
        levelUpButtons(false);
    };

    private void saveCharacteristics() {
        player.setHealth(tmpHealth);
        player.setDamage(tmpDamage);
        player.setLuck(tmpLuck);
        player.setCoins(leftCoin);
        player.setCharacteristicLevel(playerFutureLevel);
    }

    public class rest implements ActionListener {
        boolean levelUp;

        public rest(boolean levelUp) {
            this.levelUp = levelUp;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (levelUp) {
                saveCharacteristics();
            }
            player.setCurrentHealth(player.getHealth());
            new PlayerController(player).incrementRooms();
            restGui.leaveRoom();
        }
    }

}
