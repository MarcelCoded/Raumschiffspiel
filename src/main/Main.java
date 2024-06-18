package main;

import javax.swing.*;

public class Main {
    public static JFrame fenster;

    public static void main(String[] args) {
        fenster = new JFrame();
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenster.setResizable(false);
        fenster.setTitle("Super duper Raumschiff Spiel");

        Spielfenster spielfenster = new Spielfenster();
        fenster.add(spielfenster);

        fenster.pack();

        fenster.setLocationRelativeTo(null);
        fenster.setVisible(true);


        spielfenster.setupGame();
        spielfenster.startGameThread();
    }
}
