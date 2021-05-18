package frames;

import Entiry.Enemy;
import components.Padding;
import components.StatusBar;
import main.Main;

import javax.swing.*;

public class Fight extends Content {
    public Fight() {
        super();

        // Elements
        StatusBar player = new StatusBar(Main.player);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;

        add(player, gridBagConstraints);

        // Attack selection
        Padding attackSelection = new Padding(50, 50, 50, 50);

        // fire
        Padding fireButton = new Padding(0, 0, 50, 50);
        JButton fire = new JButton("fire");
        fireButton.add(fire);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;

        attackSelection.add(fireButton, gridBagConstraints);

        // water
        Padding waterButton = new Padding(0, 50, 50, 0);
        JButton water = new JButton("water");
        waterButton.add(water);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;

        attackSelection.add(waterButton, gridBagConstraints);

        // earth
        Padding earthButton = new Padding(50, 0, 0, 50);
        JButton earth = new JButton("earth");
        earthButton.add(earth);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;

        attackSelection.add(earthButton, gridBagConstraints);

        // air
        Padding airButton = new Padding(50, 50, 0, 0);
        JButton air = new JButton("air");
        airButton.add(air);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;

        attackSelection.add(airButton, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1;

        add(attackSelection, gridBagConstraints);

        // Enemy Status Bar
        StatusBar enemy = new StatusBar(new Enemy("Goblin", 10, 2));

        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1;

        add(enemy, gridBagConstraints);
    }
}
