package block;

import main.Spielfenster;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ObjektManager {
    Spielfenster gp;
    public Block[] block;
    public int mapObjektNum[][];

    public ObjektManager(Spielfenster gp) {
        this.gp = gp;
        block = new Block[10];
        mapObjektNum = new int[gp.maxWeltSpalten][gp.maxWeltZeilen];

        getObjektBilder();
        ladeMap("/karte/map.txt");
    }

    public void getObjektBilder() {
        try {
            block[0] = new Block();
            block[0].bild = ImageIO.read(getClass().getResourceAsStream("/images/objekte/schwarz.png"));

            block[1] = new Block();
            block[1].bild = ImageIO.read(getClass().getResourceAsStream("/images/objekte/schwarz.png")); //Border
            block[1].kollision = true;

            block[2] = new Block();
            block[2].bild = ImageIO.read(getClass().getResourceAsStream("/images/objekte/RoterPlanet.png"));

            block[3] = new Block();
            block[3].bild = ImageIO.read(getClass().getResourceAsStream("/images/objekte/SchwarzesRaumschiff.png"));
            block[3].kollision = true;

            block[4] = new Block();
            block[4].bild = ImageIO.read(getClass().getResourceAsStream("/images/objekte/Ufo.png"));
            block[4].kollision = true;

            block[5] = new Block();
            block[5].bild = ImageIO.read(getClass().getResourceAsStream("/images/objekte/Raumstation.png"));
            block[5].kollision = true;

            block[6] = new Block();
            block[6].bild = ImageIO.read(getClass().getResourceAsStream("/images/objekte/RingPlanet.png"));

            block[7] = new Block();
            block[7].bild = ImageIO.read(getClass().getResourceAsStream("/images/objekte/Stern.png"));
            block[7].kollision = true;

            block[8] = new Block();
            block[8].bild = ImageIO.read(getClass().getResourceAsStream("/images/objekte/BlauerPlanet.png"));

            block[9] = new Block();
            block[9].bild = ImageIO.read(getClass().getResourceAsStream("/images/objekte/Mond.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void ladeMap(String filePath) {
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int col = 0;
            int row = 0;
            while(col < gp.maxWeltSpalten && row < gp.maxWeltZeilen) {
                String line = br.readLine();
                while(col < gp.maxWeltSpalten) {
                    String[] nummern = line.split(" ");
                    int num = Integer.parseInt(nummern[col]);
                    mapObjektNum[col][row] = num;
                    col++;
                }
                if (col == gp.maxWeltSpalten) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void ladeBild(Graphics2D g2) {


        int weltSpalten = 0;
        int weltZeilen = 0;


        while(weltSpalten < gp.maxWeltSpalten && weltZeilen < gp.maxWeltZeilen) {
            int blockNum = mapObjektNum[weltSpalten][weltZeilen];

            int weltX = weltSpalten * gp.blockGroesse;
            int weltY = weltZeilen * gp.blockGroesse;
            int screenX = weltX - gp.spieler.weltX + gp.spieler.screenX;
            int screenY = weltY - gp.spieler.weltY + gp.spieler.screenY;

            if (weltX + gp.blockGroesse > gp.spieler.weltX - gp.spieler.screenX &&
                    weltX - gp.blockGroesse < gp.spieler.weltX + gp.spieler.screenX &&
                    weltY + gp.blockGroesse > gp.spieler.weltY - gp.spieler.screenY &&
                    weltY - gp.blockGroesse < gp.spieler.weltY + gp.spieler.screenY) {
                g2.drawImage(block[blockNum].bild, screenX, screenY, gp.blockGroesse, gp.blockGroesse, null);
            }
            weltSpalten++;

            if (weltSpalten == gp.maxWeltSpalten) {
                weltSpalten = 0;
                weltZeilen++;
            }
        }

    }

    //        g2.drawImage(objekt[0].image, 0, 0, gp.tileSize, gp.tileSize, null);
//        g2.drawImage(objekt[1].image, 48, 0, gp.tileSize, gp.tileSize, null);
//        g2.drawImage(objekt[2].image, 96, 0, gp.tileSize, gp.tileSize, null);
}
