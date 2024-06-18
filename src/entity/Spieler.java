package entity;

import main.Spielfenster;
import main.EingabeHandler;
import objekte.ZerstoerterMeteorit;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class Spieler extends Entity {
    Spielfenster gp;
    EingabeHandler keyH;
    public final int screenX;
    public final int screenY;
    public int sternenstaubAnzahl = 0;
    public static int zerstoerteMeteoriten = 0;
    public boolean astronautAnBoard = false;
    public static String teleportiert = "";


    public Spieler(Spielfenster gp, EingabeHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        screenX = gp.screenBreite / 2 - (gp.blockGroesse / 2);
        screenY = gp.screenHoehe / 2 - (gp.blockGroesse / 2);

        festkoerper = new Rectangle();
        festkoerper.x = 8;
        festkoerper.y = 16;
        festkoerperX = festkoerper.x;
        festkoeperY = festkoerper.y;
        festkoerper.width = 32;
        festkoerper.height = 32;


        setzeStandardWerte();
        getRaumschiffBilder();
    }

    public void setzeStandardWerte() {
        weltX = gp.blockGroesse * (gp.maxWeltSpalten / 2); //Startposition
        weltY = gp.blockGroesse * (gp.maxWeltZeilen / 2);
        speed = 4;
        richtung = "up";
    }

    public void getRaumschiffBilder() {
        try {
            hoch = ImageIO.read(getClass().getResourceAsStream("/images/raumschiff/Raumschiff.png"));
            runter = ImageIO.read(getClass().getResourceAsStream("/images/raumschiff/RaumschiffUnten.png"));
            links = ImageIO.read(getClass().getResourceAsStream("/images/raumschiff/RaumschiffLinks.png"));
            rechts = ImageIO.read(getClass().getResourceAsStream("/images/raumschiff/RaumschiffRechts.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (this.keyH.hoch || this.keyH.runter || this.keyH.links || this.keyH.rechts) {
            if (keyH.hoch == true) {
                richtung = "up";
            } else if (keyH.runter == true) {
                richtung = "down";
            } else if (keyH.links == true) {
                richtung = "left";
            } else if (keyH.rechts == true) {
                richtung = "right";
            }

            //Auf Kollisionen prüfen:
            kollisionAn = false;
            gp.kollisionenChecker.checkBlock(this);

            //Auf Objekt Kollisionen prüfen:
            int objektIndex = gp.kollisionenChecker.checkObjekt(this, true);
            objektAufheben(objektIndex);

            if (kollisionAn == false) {
                switch (richtung) {
                    case "up" -> weltY -= speed;
                    case "down" -> weltY += speed;
                    case "left" -> weltX -= speed;
                    case "right" -> weltX += speed;
                }
            }
        }
    }

    public void objektAufheben(int index) {

        if (index != 999) {
            String objektName = gp.obj[index].name;

            switch (objektName) {
                case "Schwarzes Loch":
                    teleportiert = "- Erledigt!";
                    if (index == 2) {
                        gp.spieler.weltX = gp.blockGroesse * 10;
                        gp.spieler.weltY = gp.blockGroesse * 10;
                    } else if (index == 3) {
                        gp.spieler.weltX = gp.blockGroesse * 88;
                        gp.spieler.weltY = gp.blockGroesse * 7;
                    } else if (index == 4) {
                        gp.spieler.weltX = gp.blockGroesse * 88;
                        gp.spieler.weltY = gp.blockGroesse * 81;
                    } else if (index == 5) {
                        gp.spieler.weltX = gp.blockGroesse * 7;
                        gp.spieler.weltY = gp.blockGroesse * 69;
                    }
                    gp.ui.zeigeNachricht("Du wurdest teleportiert!");
                    break;
                case "Sternenstaub":
                    sternenstaubAnzahl++;
                    gp.obj[index] = null;
                    gp.ui.zeigeNachricht("Du hast Sternenstaub gefunden!");
                    break;
                case "Sternschnuppe":
                    speed += 2;
                    gp.obj[index] = null;
                    gp.ui.zeigeNachricht("Mehr Speed!");
                    break;
                case "Erde":
                    if (astronautAnBoard) {
                        gp.ui.spielBeendet = true;
                        gp.ui.zeigeNachricht("Spiel vorbei");
                    }
                    break;
                case "Astronaut":
                    astronautAnBoard = true;
                    gp.obj[index] = null;
                    gp.ui.zeigeNachricht("Astronaut gefunden!");
                    break;
                case "Meteorit":
                    int x = gp.obj[index].worldX;
                    int y = gp.obj[index].worldY;
                    zerstoerteMeteoriten++;
                    gp.obj[index] = new ZerstoerterMeteorit();
                    gp.obj[index].worldX = x;
                    gp.obj[index].worldY = y;
                    gp.ui.zeigeNachricht("Du hast einen Meteoriten zerstört!");
                    break;
            }
        }

    }

    public void ladeBild(Graphics2D g2) {

        BufferedImage bild = null;
        switch (richtung) {
            case "up":
                bild = hoch;
                break;
            case "down":
                bild = runter;
                break;
            case "left":
                bild = links;
                break;
            case "right":
                bild = rechts;
                break;
        }
        g2.drawImage(bild, screenX, screenY, gp.blockGroesse, gp.blockGroesse, null);
    }
}
