package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EingabeHandler implements KeyListener {

    public boolean hoch, runter, links, rechts;

    boolean checkDailyMissions = false;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            hoch = true;
        }

        if (code == KeyEvent.VK_S) {
            runter = true;
        }

        if (code == KeyEvent.VK_A) {
            links = true;
        }

        if (code == KeyEvent.VK_D) {
            rechts = true;
        }

        if (code == KeyEvent.VK_T) {
            if (checkDailyMissions == false) {
                checkDailyMissions = true;
            } else if (checkDailyMissions == true) {
                checkDailyMissions = false;
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            hoch = false;
        }

        if (code == KeyEvent.VK_S) {
            runter = false;
        }

        if (code == KeyEvent.VK_A) {
            links = false;
        }

        if (code == KeyEvent.VK_D) {
            rechts = false;
        }
    }
}
