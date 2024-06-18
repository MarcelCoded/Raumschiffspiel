package main;

import entity.Entity;

public class KollisionsPruefer {
    Spielfenster gp;

    public KollisionsPruefer(Spielfenster gp) {
        this.gp = gp;
    }

    public void checkBlock(Entity entity) {
        int entityLinksX = entity.weltX + entity.festkoerper.x;
        int entityRechtsX = entity.weltX + entity.festkoerper.x + entity.festkoerper.width;
        int entityObenY = entity.weltY + entity.festkoerper.y;
        int entityUntenY = entity.weltY + entity.festkoerper.y + entity.festkoerper.height;

        int entityLinkeSpalte = entityLinksX / gp.blockGroesse;
        int entityRechteSpalte = entityRechtsX / gp.blockGroesse;
        int entityObereZeile = entityObenY / gp.blockGroesse;
        int entityUntereZeile = entityUntenY / gp.blockGroesse;

        int objektNum1, objektNum2;

        switch (entity.richtung) {
            case "up":
                entityObereZeile = (entityObenY - entity.speed) / gp.blockGroesse;
                objektNum1 = gp.objektM.mapObjektNum[entityLinkeSpalte][entityObereZeile];
                objektNum2 = gp.objektM.mapObjektNum[entityRechteSpalte][entityObereZeile];
                if (gp.objektM.block[objektNum1].kollision == true || gp.objektM.block[objektNum2].kollision == true) {
                    entity.kollisionAn = true;
                }
                break;
            case "down":
                entityUntereZeile = (entityUntenY + entity.speed) / gp.blockGroesse;
                objektNum1 = gp.objektM.mapObjektNum[entityLinkeSpalte][entityUntereZeile];
                objektNum2 = gp.objektM.mapObjektNum[entityRechteSpalte][entityUntereZeile];
                if (gp.objektM.block[objektNum1].kollision == true || gp.objektM.block[objektNum2].kollision == true) {
                    entity.kollisionAn = true;
                }
                break;
            case "left":
                entityLinkeSpalte = (entityLinksX - entity.speed) / gp.blockGroesse;
                objektNum1 = gp.objektM.mapObjektNum[entityLinkeSpalte][entityObereZeile];
                objektNum2 = gp.objektM.mapObjektNum[entityLinkeSpalte][entityUntereZeile];
                if (gp.objektM.block[objektNum1].kollision == true || gp.objektM.block[objektNum2].kollision == true) {
                    entity.kollisionAn = true;
                }
                break;
            case "right":
                entityRechteSpalte = (entityRechtsX + entity.speed) / gp.blockGroesse;
                objektNum1 = gp.objektM.mapObjektNum[entityRechteSpalte][entityObereZeile];
                objektNum2 = gp.objektM.mapObjektNum[entityRechteSpalte][entityUntereZeile];
                if (gp.objektM.block[objektNum1].kollision == true || gp.objektM.block[objektNum2].kollision == true) {
                    entity.kollisionAn = true;
                }
                break;
        }
    }

    public int checkObjekt(Entity entity, boolean player) {
        int index = 999;

        for (int i = 0; i < gp.obj.length; i++) {
            if (gp.obj[i] != null) {
                entity.festkoerper.x = entity.weltX + entity.festkoerper.x;
                entity.festkoerper.y = entity.weltY + entity.festkoerper.y;
                gp.obj[i].festkoeper.x = gp.obj[i].worldX + gp.obj[i].festkoeper.x;
                gp.obj[i].festkoeper.y = gp.obj[i].worldY + gp.obj[i].festkoeper.y;

                switch (entity.richtung) {
                    case "up":
                        entity.festkoerper.y -= entity.speed;
                        if (entity.festkoerper.intersects(gp.obj[i].festkoeper)) {
//                            if (gp.obj[i].collision == true) {
//                                entity.collisionOn = true;
//                            }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        entity.festkoerper.y += entity.speed;
                        if (entity.festkoerper.intersects(gp.obj[i].festkoeper)) {
//                            if (gp.obj[i].collision == true) {
//                                entity.collisionOn = true;
//                            }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        entity.festkoerper.x -= entity.speed;
                        if (entity.festkoerper.intersects(gp.obj[i].festkoeper)) {
//                            if (gp.obj[i].collision == true) {
//                                entity.collisionOn = true;
//                            }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        entity.festkoerper.x += entity.speed;
                        if (entity.festkoerper.intersects(gp.obj[i].festkoeper)) {
//                            if (gp.obj[i].collision == true) {
//                                entity.collisionOn = true;
//                            }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                }
                entity.festkoerper.x = entity.festkoerperX;
                entity.festkoerper.y = entity.festkoeperY;
                gp.obj[i].festkoeper.x = gp.obj[i].festkoeperX;
                gp.obj[i].festkoeper.y = gp.obj[i].festkoeperY;
            }
        }

        return index;
    }
}
