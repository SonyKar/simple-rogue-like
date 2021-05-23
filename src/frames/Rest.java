package frames;

import Utilities.Configuration;
import components.Characteristic;
import engines.LevelUpEngine;

import javax.swing.*;
import java.awt.*;

import static main.Main.player;

public class Rest extends JPanel {
    JLabel purse, coinsPerLevel;
    Characteristic health, damage, luck;

    public Rest() {
        setLayout(new GridLayout(0, 2)); // as many rows as necessary
        // Elements

        // (0, 0)
        add(new Label());

        // Element init
        health = new Characteristic("Health", Configuration.playerHealthPerLevel, player.getHealth());
        damage = new Characteristic("Damage", Configuration.playerDamagePerLevel, player.getDamage());
        luck = new Characteristic("Luck", Configuration.playerLuckPerLevel, player.getLuck());
        purse = new JLabel("Coins: ");
        coinsPerLevel = new JLabel("Next level costs x coins");
        JButton restLevelUpButton = new JButton("Rest & Level up");
        JButton justRestButton = new JButton("Just Rest");
        LevelUpEngine levelUpEngine = new LevelUpEngine(this);

        health.getPlusButton().addActionListener(levelUpEngine.healthLevelUp);
        health.getMinusButton().addActionListener(levelUpEngine.healthDownGrade);
        damage.getPlusButton().addActionListener(levelUpEngine.damageLevelUp);
        damage.getMinusButton().addActionListener(levelUpEngine.damageDownGrade);
        luck.getPlusButton().addActionListener(levelUpEngine.luckLevelUp);
        luck.getMinusButton().addActionListener(levelUpEngine.luckDownGrade);

        restLevelUpButton.addActionListener(levelUpEngine.new rest(true));
        justRestButton.addActionListener(levelUpEngine.new rest(false));

        // (0, 1)
        JPanel levelUp = new JPanel();
        levelUp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        levelUp.setLayout(new BoxLayout(levelUp, BoxLayout.Y_AXIS));

        levelUp.add(health);
        levelUp.add(damage);
        levelUp.add(luck);
        levelUp.add(purse);
        levelUp.add(coinsPerLevel);
        levelUp.add(restLevelUpButton);
        levelUp.add(justRestButton);

        add(levelUp);
    }

    public void actualizePurse(int coins) {
        purse.setText("Coins: " + coins);
    }

    public void actualizeCostPerLevel(int coins) {
        coinsPerLevel.setText("Next level costs " + coins + " coins");
    }

    public Characteristic getHealth() {
        return health;
    }

    public Characteristic getDamage() {
        return damage;
    }

    public Characteristic getLuck() {
        return luck;
    }
}
