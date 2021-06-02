package frames;

import engines.LoginEngine;

import static main.Main.gameWindow;
import javax.swing.*;

public class Login extends Content {
    public Login() {
        super();

        // Elements
        JLabel loginText = new JLabel("Login: ");
        JTextField loginField = new JTextField(10);

        JLabel passwordText = new JLabel("Password: ");
        JPasswordField password = new JPasswordField(10);

        JButton loginButton = new JButton("Log in");

        loginButton.addActionListener(e -> {
            if (new LoginEngine(this, loginField.getText(), String.valueOf(password.getPassword())).connect()) {
                gameWindow.changeContent(new MainMenu(), "Main Menu");
            } else {
                JOptionPane.showMessageDialog(this,
                        "Invalid password. Try again.",
                        "Error Message",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;

        add(loginText, gridBagConstraints);

        gridBagConstraints.gridx = 1;

        add(loginField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;

        add(passwordText, gridBagConstraints);

        gridBagConstraints.gridx = 1;

        add(password, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;

        add(loginButton, gridBagConstraints);
    }
}
