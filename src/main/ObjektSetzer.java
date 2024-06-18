package main;

import objekte.*;

public class ObjektSetzer {
    Spielfenster gp;

    public ObjektSetzer(Spielfenster gp) {
        this.gp = gp;
    }

    public void setzeObjekt() {
        gp.obj[0] = new Erde();
        gp.obj[0].worldX = 21 * gp.blockGroesse;
        gp.obj[0].worldY = 26 * gp.blockGroesse;

        gp.obj[1] = new Astronaut();
        gp.obj[1].worldX = 44 * gp.blockGroesse;
        gp.obj[1].worldY = 4 * gp.blockGroesse;



        gp.obj[2] = new SchwarzesLoch();
        gp.obj[2].worldX = 88 * gp.blockGroesse;
        gp.obj[2].worldY = 8 * gp.blockGroesse;

        gp.obj[3] = new SchwarzesLoch();
        gp.obj[3].worldX = 10 * gp.blockGroesse;
        gp.obj[3].worldY = 11 * gp.blockGroesse;

        gp.obj[4] = new SchwarzesLoch();
        gp.obj[4].worldX = 7 * gp.blockGroesse;
        gp.obj[4].worldY = 68 * gp.blockGroesse;

        gp.obj[5] = new SchwarzesLoch();
        gp.obj[5].worldX = 88 * gp.blockGroesse;
        gp.obj[5].worldY = 80 * gp.blockGroesse;




        gp.obj[6] = new Sternschnuppe();
        gp.obj[6].worldX = 8 * gp.blockGroesse;
        gp.obj[6].worldY = 28 * gp.blockGroesse;

        gp.obj[7] = new Sternschnuppe();
        gp.obj[7].worldX = 6 * gp.blockGroesse;
        gp.obj[7].worldY = 5 * gp.blockGroesse;

        gp.obj[8] = new Sternschnuppe();
        gp.obj[8].worldX = 44 * gp.blockGroesse;
        gp.obj[8].worldY = 66 * gp.blockGroesse;

        gp.obj[9] = new Sternschnuppe();
        gp.obj[9].worldX = 91 * gp.blockGroesse;
        gp.obj[9].worldY = 88 * gp.blockGroesse;

        gp.obj[10] = new Sternschnuppe();
        gp.obj[10].worldX = 24 * gp.blockGroesse;
        gp.obj[10].worldY = 56 * gp.blockGroesse;




        gp.obj[11] = new Sternenstaub();
        gp.obj[11].worldX = 23 * gp.blockGroesse;
        gp.obj[11].worldY = 7 * gp.blockGroesse;

        gp.obj[12] = new Sternenstaub();
        gp.obj[12].worldX = 23 * gp.blockGroesse;
        gp.obj[12].worldY = 40 * gp.blockGroesse;

        gp.obj[13] = new Sternenstaub();
        gp.obj[13].worldX = 4 * gp.blockGroesse;
        gp.obj[13].worldY = 15 * gp.blockGroesse;

        gp.obj[14] = new Sternenstaub();
        gp.obj[14].worldX = 90 * gp.blockGroesse;
        gp.obj[14].worldY = 40 * gp.blockGroesse;

        gp.obj[15] = new Sternenstaub();
        gp.obj[15].worldX = 37 * gp.blockGroesse;
        gp.obj[15].worldY = 90 * gp.blockGroesse;



        gp.obj[16] = new Meteorit();
        gp.obj[16].worldX = 20 * gp.blockGroesse;
        gp.obj[16].worldY = 17 * gp.blockGroesse;

        gp.obj[17] = new Meteorit();
        gp.obj[17].worldX = 30 * gp.blockGroesse;
        gp.obj[17].worldY = 4 * gp.blockGroesse;

        gp.obj[18] = new Meteorit();
        gp.obj[18].worldX = 12 * gp.blockGroesse;
        gp.obj[18].worldY = 34 * gp.blockGroesse;

        gp.obj[19] = new Meteorit();
        gp.obj[19].worldX = 19 * gp.blockGroesse;
        gp.obj[19].worldY = 77 * gp.blockGroesse;

        gp.obj[20] = new Meteorit();
        gp.obj[20].worldX = 64 * gp.blockGroesse;
        gp.obj[20].worldY = 2 * gp.blockGroesse;
    }
}
