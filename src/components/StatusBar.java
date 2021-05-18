package components;

import Entiry.Entity;
import frames.Content;

import javax.swing.*;
import java.awt.*;

public class StatusBar extends Content {
    public StatusBar(Entity entity) {
        super();

        GridBagConstraints gridBagConstraints = getGridBagConstraints();

        // Elements
        Padding padding = new Padding(10, 10, 10, 10);

        // Health bar
        JLabel health = new JLabel(entity.getCurrentHealth() + "\\" + entity.getHealth());

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;

        padding.add(health, gridBagConstraints);

        // Name
        JLabel name = new JLabel(entity.getName());
        Padding nameMargin = new Padding(0, 20, 0, 0);
        nameMargin.add(name);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;

        padding.add(nameMargin, gridBagConstraints);

        // Damage bar
        JLabel damage = new JLabel("" + entity.getDamage());

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;

        padding.add(damage, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;

        add(padding, gridBagConstraints);
    }
}
