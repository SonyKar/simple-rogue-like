package main;

import Model.Player;
import frames.GameWindow;
import frames.Login;

public class Main {
    public static Player player;
    public static Model.Login login;
    public static GameWindow gameWindow;

    public static void main(String[] args) {
        player = new Player("test", 50, 5, 1, 0);
        gameWindow = new GameWindow("Main Menu", new Login());
    }
}