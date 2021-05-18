package main;

import frames.GameWindow;
import frames.MainMenu;

public class Main {
    public static GameWindow gameWindow;
    public static void main(String[] args) {
        gameWindow = new GameWindow("main.Main Menu", new MainMenu());
    }
}
