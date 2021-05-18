package frames;

import main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel {
    public MainMenu() {
        // JPanel Properties
        setLayout(new GridBagLayout());

        // GridBagLayout properties
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;

        // Elements
        JPanel mainMenu = new JPanel();
        mainMenu.setSize(200, 300);
        mainMenu.setLayout(new GridBagLayout());

        JLabel gameName = new JLabel(
                "<html>" +
                        "<p style=\"text-align: center\">Simple</p>" +
                        "<p style=\"text-align: center\">Rogue Like</p>" +
                    "</html>"
        );
        gameName.setHorizontalAlignment(JLabel.CENTER);
        gameName.setFont(new Font(GameWindow.fontName, Font.BOLD, 40));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;

        mainMenu.add(gameName, gridBagConstraints);

        JButton startGame=new JButton("Start Game");
        startGame.setFont(new Font(GameWindow.fontName, Font.PLAIN, 18));
        startGame.addActionListener(e -> Main.gameWindow.changeContent(new RoomSelection()));

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;

        mainMenu.add(startGame, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 3;

        add(mainMenu, gridBagConstraints);
    }
}
