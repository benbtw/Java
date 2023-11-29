package com.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    static boolean over = true;

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_D -> Player.right = true;
            case KeyEvent.VK_A -> Player.left = true;
            case KeyEvent.VK_S -> Player.down = true;
            case KeyEvent.VK_W, KeyEvent.VK_SPACE -> {
                if(over) {
                    Player.up = true;
                    over = false;
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_D -> Player.right = false;
            case KeyEvent.VK_A -> Player.left = false;
            case KeyEvent.VK_S -> Player.down = false;
            case KeyEvent.VK_W, KeyEvent.VK_SPACE -> {
                if(!over) {
                    Player.up = false;
                    over = true;
                }
            }
        }
    }
}
