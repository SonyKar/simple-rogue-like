package frames;

import javax.swing.*;
import java.awt.*;

public abstract class Content extends JPanel {
    GridBagConstraints gridBagConstraints;

    public Content() {
        setLayout(new GridBagLayout());

        this.gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
    }

    public GridBagConstraints getGridBagConstraints() {
        return gridBagConstraints;
    }
}
