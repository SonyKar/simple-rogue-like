package engines;

import DAO.loginDB;
import frames.Login;

import static main.Main.login;

public class LoginEngine {
    Login gui;
    String loginText;
    String passwordText;

    public LoginEngine(Login gui, String loginText, String passwordText) {
        this.gui = gui;
        this.loginText = loginText;
        this.passwordText = passwordText;
    }

    public boolean connect() {
        login = new loginDB().read(loginText, passwordText);
        return login != null;
    }
}
