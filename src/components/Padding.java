package components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Padding extends JPanel {
    public Padding(int top, int left, int bottom, int right) {
        // JPanel Properties
        setLayout(new GridBagLayout());
        setBorder(new EmptyBorder(top, left, bottom, right));

        // GridBagLayout properties
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
    }
}
