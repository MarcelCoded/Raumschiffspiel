package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    public int weltX, weltY;
    public int speed;
    public BufferedImage hoch, runter, links, rechts;
    public String richtung;
    public Rectangle festkoerper;
    public int festkoerperX, festkoeperY;
    public boolean kollisionAn = false;



}
