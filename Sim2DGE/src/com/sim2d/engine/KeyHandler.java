package com.sim2d.engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean up, left, right, down;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode)
        {
            case KeyEvent.VK_D:
                right = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode)
        {
            case KeyEvent.VK_D:
                right = false;
                break;
        }
    }
}
