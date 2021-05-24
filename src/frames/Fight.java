package frames;

import Factory.FightFactory;
import components.Padding;
import components.StatusBar;
import engines.FightEngine;
import main.Main;

import javax.swing.*;
import java.awt.*;

public class Fight extends Content {
    private final FightEngine fightEngine;
    private final StatusBar player;
    private final StatusBar enemy;
    private final JLabel enemySelection;
    private final JLabel playerSelection;

    public Fight() {
        super();

        fightEngine = new FightEngine(this, new FightFactory().generateFight());

        // Elements
        player = new StatusBar(Main.player);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;

        add(player, gridBagConstraints);

        playerSelection = new JLabel("");
        playerSelection.setFont(new Font(GameWindow.fontName, Font.BOLD, 40));
        enemySelection = new JLabel("");
        enemySelection.setHorizontalAlignment(JLabel.RIGHT);
        enemySelection.setFont(new Font(GameWindow.fontName, Font.BOLD, 40));

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;

        add(playerSelection, gridBagConstraints);

        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;

        add(enemySelection, gridBagConstraints);

        // Attack selection
        Padding attackSelection = new Padding(50, 50, 50, 50);

        // fire
        Padding fireButton = new Padding(0, 0, 25, 50);
        JButton fire = new JButton("fire");
        fireButton.add(fire);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;

        attackSelection.add(fireButton, gridBagConstraints);

        // water
        Padding waterButton = new Padding(0, 50, 25, 0);
        JButton water = new JButton("water");
        waterButton.add(water);

        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;

        attackSelection.add(waterButton, gridBagConstraints);

        // metal
        Padding metalButton = new Padding(0, 0, 0, 0);
        JButton metal = new JButton("metal");
        metalButton.add(metal);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;

        attackSelection.add(metalButton, gridBagConstraints);

        // earth
        Padding earthButton = new Padding(25, 0, 0, 50);
        JButton earth = new JButton("earth");
        earthButton.add(earth);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 1;

        attackSelection.add(earthButton, gridBagConstraints);

        // wood
        Padding woodButton = new Padding(25, 50, 0, 0);
        JButton wood = new JButton("wood");
        woodButton.add(wood);

        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 1;

        attackSelection.add(woodButton, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 1;

        add(attackSelection, gridBagConstraints);

        fire.addActionListener( e -> fightEngine.makeMove(FightEngine.Element.FIRE));
        water.addActionListener( e -> fightEngine.makeMove(FightEngine.Element.WATER));
        metal.addActionListener( e -> fightEngine.makeMove(FightEngine.Element.METAL));
        wood.addActionListener( e -> fightEngine.makeMove(FightEngine.Element.WOOD));
        earth.addActionListener( e -> fightEngine.makeMove(FightEngine.Element.EARTH));

        // Enemy Status Bar
        enemy = new StatusBar(fightEngine.getFightModel().getEnemy());

        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1;

        add(enemy, gridBagConstraints);
    }

    public void actualisePlayer(int currentHealth, int health) {
        player.getHealth().setText(currentHealth + "\\" + health);
    }

    public void actualiseEnemy(int currentHealth, int health) {
        enemy.getHealth().setText(currentHealth + "\\" + health);
    }

    public void actualiseEnemySelection(String elementName, boolean isWin) {
        enemySelection.setText(elementName);
        enemySelection.setForeground(isWin ? Color.GREEN : Color.RED);
    }

    public void actualisePlayerSelection(String elementName, boolean isWin) {
        playerSelection.setText(elementName);
        playerSelection.setForeground(isWin ? Color.GREEN : Color.RED);
    }

    public void leaveRoom(int coins) {
        Main.gameWindow.changeContent(new Treasure(coins), "Treasury");
    }
}
