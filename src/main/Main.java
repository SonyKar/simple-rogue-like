package main;

import Entiry.Player;
import frames.GameWindow;
import frames.MainMenu;

public class Main {
    public static Player player;
    public static GameWindow gameWindow;
    public static void main(String[] args) {
        player = new Player("test", 50, 5, 1, 0);
        gameWindow = new GameWindow("Main Menu", new MainMenu());
    }
}
