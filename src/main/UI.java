package main;

import entity.Spieler;
import objekte.Sternenstaub;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {
    Spielfenster gp;
    Font arial_40, arial_80B;
    BufferedImage staubBild;
    public boolean nachrichtAn = false;
    public String nachricht = "";
    int nachrichtenCounter = 0;
    public boolean spielBeendet = false;

    public UI(Spielfenster gp) {
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);
        Sternenstaub sternenstaub = new Sternenstaub();
        staubBild = sternenstaub.bild;
    }

    public void zeigeNachricht(String text) {
        nachricht = text;
        nachrichtAn = true;
    }
    public void ladeBild(Graphics2D g2) {

        if (spielBeendet == true) {
            String text;
            int textLaenge;
            int x;
            int y;

            g2.setFont(arial_40);
            g2.setColor(Color.white);
            text = "Die Erde erreicht!";
            textLaenge = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenBreite /2 - textLaenge/2;
            y = gp.screenHoehe /2 - (gp.blockGroesse *3);
            g2.drawString(text, x, y);

            g2.setFont(arial_80B);
            g2.setColor(Color.green);
            text = "Spiel beendet!";
            textLaenge = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenBreite /2 - textLaenge/2;
            y = gp.screenHoehe /2 + (gp.blockGroesse *2);
            g2.drawString(text, x, y);

            gp.spielThread = null; //Beendet das Spiel
        } else {
            g2.setFont(arial_40);
            g2.setColor(Color.white);
            g2.drawImage(staubBild, gp.blockGroesse /2, gp.blockGroesse /2, gp.blockGroesse, gp.blockGroesse, null);
            g2.drawString(" x " + gp.spieler.sternenstaubAnzahl, 74, 65);

            if (nachrichtAn == true) {
                g2.setFont(g2.getFont().deriveFont(30F));
                int textLength = (int)g2.getFontMetrics().getStringBounds(nachricht, g2).getWidth();
                int x = gp.screenBreite /2 - textLength/2;

                g2.drawString(nachricht, x, gp.screenHoehe -20); //Koordinaten, an denen der Text gespawnt wird
                nachrichtenCounter++;

                if (nachrichtenCounter > 180) {
                    nachrichtenCounter = 0;
                    nachrichtAn = false;
                }
            }

            if (gp.dailyMissionPruefen) {
                oeffneDailyMissionFenster(g2);
            }

        }
    }

    private void oeffneDailyMissionFenster(Graphics2D g2) {
        int x = gp.blockGroesse *14;
        int y = gp.blockGroesse /2;
        int breite = gp.screenBreite - (gp.blockGroesse *26);
        int hoehe = gp.blockGroesse * 4;


        Color c = new Color(100,100,100, 180); //180 gibt die Stärke Deckkraft an
        g2.setColor(c);
        g2.fillRoundRect(x, y, breite, hoehe, 35, 35);

        c = new Color(255, 255, 255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5, y+5, breite-10, hoehe-10, 25, 25);

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 22F));
        x += gp.blockGroesse;
        y += gp.blockGroesse;

        String dailyMissionen = "Deine Missionen:" +
                "\n - Zerstöre Meteoriten " + Spieler.zerstoerteMeteoriten + "/2" +
                "\n - Teleportiere dich " + Spieler.teleportiert +
                "\n - Finde den Astronauten und bringe ihn zur Erde!";

        for (String zeile : dailyMissionen.split("\n")) {
            g2.drawString(zeile, x, y);
            y+=40;
        }
    }
}
