package frames;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    static String fontName = "Calibri";
    JPanel content;

    public GameWindow(String title, JPanel content) {
        // Window Properties
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 200 ,700, 500);
        setLayout(new GridBagLayout());
        setVisible(true);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;

        this.content = content;
        getContentPane().add(content, gridBagConstraints);
    }

    public void changeContent(JPanel content) {
        getContentPane().removeAll();

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;

        this.content = content;
        getContentPane().add(content, gridBagConstraints);
        revalidate();
    }
}
