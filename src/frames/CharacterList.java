package frames;

import Utilities.Configuration;
import components.Padding;

import javax.swing.*;

import java.awt.*;

import static main.Main.player;

public class CharacterList extends JFrame {
    public CharacterList() {
        super("Character List");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(400, 200 ,250, 350);
        setLayout(new GridLayout(1, 1));
        setVisible(true);

        Padding padding = new Padding(20, 20, 20, 20);

        // Elements
        JLabel name = new JLabel(player.getName());
        name.setFont(new Font(GameWindow.fontName, Font.BOLD, 40));

        Padding characteristics = new Padding(5, 5, 5, 5);

        JLabel health = new JLabel("Health: ");
        JLabel healthValue = new JLabel( player.getCurrentHealth() + "\\" + player.getHealth());
        JLabel damage = new JLabel("Damage: ");
        JLabel damageValue = new JLabel( player.getDamage() + "");
        JLabel luck = new JLabel("Luck: ");
        JLabel luckValue = new JLabel( player.getLuck() + "");

        JLabel purse = new JLabel("Coins: " + player.getCoins());
        JLabel nextLevelCost = new JLabel("Next level costs " + player.getCharacteristicLevel() * Configuration.costPerLevel + " coins");

        JButton close = new JButton("Close");
        close.addActionListener(e -> { setVisible(false); dispose(); });

        // Characteristics
        GridBagConstraints gridBagConstraints = padding.getGridBagConstraints();

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;

        characteristics.add(health, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;

        characteristics.add(healthValue, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;

        characteristics.add(damage, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;

        characteristics.add(damageValue, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 1;

        characteristics.add(luck, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 1;

        characteristics.add(luckValue, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;

        padding.add(name, gridBagConstraints);

        gridBagConstraints.gridy = 1;

        padding.add(new JLabel("Characteristics: "), gridBagConstraints);

        gridBagConstraints.gridy = 2;

        padding.add(characteristics, gridBagConstraints);

        gridBagConstraints.gridy = 3;

        padding.add(purse, gridBagConstraints);

        gridBagConstraints.gridy = 4;

        padding.add(nextLevelCost, gridBagConstraints);

        gridBagConstraints.gridy = 5;

        padding.add(close, gridBagConstraints);

        getContentPane().add(padding);
    }
}
