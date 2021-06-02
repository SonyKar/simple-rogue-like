package frames;

import DAO.playerDB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static main.Main.login;
import static main.Main.player;

public class GameWindow extends JFrame {
    static String fontName = "Calibri";
    JPanel content;

    public GameWindow(String title, JPanel content) {
        // Window Properties
        super(title);
        setBounds(400, 200 ,700, 500);
        setLayout(new GridBagLayout());
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new playerDB().update(player, login);
                System.exit(0);
            }
        });

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

    public void changeContent(JPanel content, String title) {
        getContentPane().removeAll();

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;

        setTitle(title);
        this.content = content;
        getContentPane().add(content, gridBagConstraints);
        revalidate();
        repaint();
    }
}
