package components;

import frames.Content;

import javax.swing.*;
import java.awt.*;

public class Characteristic extends Content {
    JButton plusButton, minusButton;
    JLabel currentValue;

    public Characteristic(String title, int valuePerLevel, int playerValue) {
        super();

        GridBagConstraints gridBagConstraints = getGridBagConstraints();

        Padding characteristicNamePadding = new Padding(0, 0, 0, 20);
        JLabel characteristicName = new JLabel(title);
        characteristicNamePadding.add(characteristicName);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;

        add(characteristicNamePadding, gridBagConstraints);

        Padding minusButtonPadding = new Padding(0, 0, 0, 10);
        minusButton = new JButton("" + -valuePerLevel);
        minusButton.setEnabled(false);
        minusButtonPadding.add(minusButton);

        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;

        add(minusButtonPadding, gridBagConstraints);

        currentValue = new JLabel("" + playerValue);

        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;

        add(currentValue, gridBagConstraints);

        Padding plusButtonPadding = new Padding(0, 10, 0, 0);
        plusButton = new JButton("" + valuePerLevel);
        plusButtonPadding.add(plusButton);

        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;

        add(plusButtonPadding, gridBagConstraints);
    }

    public void enablePlusButton() {
        plusButton.setEnabled(true);
    }
    public void disablePlusButton() {
        plusButton.setEnabled(false);
    }

    public void enableMinusButton() {
        minusButton.setEnabled(true);
    }
    public void disableMinusButton() { minusButton.setEnabled(false); }

    public void actualizeCurrentValue(int newValue) {
        currentValue.setText("" + newValue);
    }

    public JButton getPlusButton() {
        return plusButton;
    }

    public JButton getMinusButton() {
        return minusButton;
    }
}
