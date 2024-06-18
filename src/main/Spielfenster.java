package main;

import entity.Spieler;
import objekte.SuperObjekt;
import block.ObjektManager;

import javax.swing.*;
import java.awt.*;

public class Spielfenster extends JPanel implements Runnable {
    //Bild Einstellungen
    private final int originalBlockGroeße = 16; //16x16
    private final int skalierFaktor = 3;
    public final int blockGroesse = originalBlockGroeße * skalierFaktor; //48x48
    public final int maxBildSpalten = 38; //16
    public final int maxBildZeilen = 21; //12
    public final int screenBreite = blockGroesse * maxBildSpalten;
    public final int screenHoehe = blockGroesse * maxBildZeilen;


    //Einstellung der Welt Größe
    public final int maxWeltSpalten = 100;
    public final int maxWeltZeilen = 100;


    ObjektManager objektM = new ObjektManager(this);
    EingabeHandler keyH = new EingabeHandler();
    public KollisionsPruefer kollisionenChecker = new KollisionsPruefer(this);
    public ObjektSetzer oSetzer = new ObjektSetzer(this);
    public UI ui = new UI(this);
    Thread spielThread;
    public boolean dailyMissionPruefen = false;
    public Spieler spieler = new Spieler(this, keyH);
    public SuperObjekt[] obj = new SuperObjekt[21]; //Anzahl der Objekte, die extra Platziert werden in AssertSetter


    public Spielfenster() {
        this.setPreferredSize(new Dimension(screenBreite, screenHoehe));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    public void setupGame() {
        oSetzer.setzeObjekt();
    }
    public void startGameThread() {
        spielThread = new Thread(this);
        spielThread.start();
    }

    public void run() {
        double zeichnungsInterval = 1000000000/60;
        double delta = 0;
        long letzteZeit = System.nanoTime();
        long aktuelleZeit;

        while(spielThread != null) {
            aktuelleZeit = System.nanoTime();

            delta += (aktuelleZeit - letzteZeit) / zeichnungsInterval;
            letzteZeit = aktuelleZeit;
            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    public void update() {
        spieler.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        if (keyH.checkDailyMissions == true) {
            dailyMissionPruefen = true;
        } else {
            dailyMissionPruefen = false;
        }


        objektM.ladeBild(g2);


        for (int i = 0; i < obj.length; i++) {
            if (obj[i] != null) {
                obj[i].ladeBild(g2, this);
            }
        }

        //Player
        spieler.ladeBild(g2);

        //UI
        ui.ladeBild(g2);

        g2.dispose();
    }

}