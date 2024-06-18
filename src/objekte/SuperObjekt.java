package objekte;

import main.Spielfenster;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObjekt {
    public BufferedImage bild;
    public String name;
    public int worldX, worldY;
    public Rectangle festkoeper = new Rectangle(0,0,48,48);
    public int festkoeperX = 0;
    public int festkoeperY = 0;

    public void ladeBild(Graphics2D g2, Spielfenster gp) {
        int screenX = worldX - gp.spieler.weltX + gp.spieler.screenX;
        int screenY = worldY - gp.spieler.weltY + gp.spieler.screenY;

        if (worldX + gp.blockGroesse > gp.spieler.weltX - gp.spieler.screenX &&
                worldX - gp.blockGroesse < gp.spieler.weltX + gp.spieler.screenX &&
                worldY + gp.blockGroesse > gp.spieler.weltY - gp.spieler.screenY &&
                worldY - gp.blockGroesse < gp.spieler.weltY + gp.spieler.screenY) {
            g2.drawImage(bild, screenX, screenY, gp.blockGroesse, gp.blockGroesse, null);
        }
    }
}
