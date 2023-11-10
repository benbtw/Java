package com.main;

import com.sim2d.engine.KeyHandler;

import java.awt.*;

public class Player {

    int x = 10, y = 10;
    int velX = 0, velY = 0;
    KeyHandler keyH = new KeyHandler();

    public void update(int dt)
    {
        if(keyH.right){
            System.out.println("key pressed");
            velX += 5 * dt;
        }
    }

    public void draw(Graphics g)
    {
        g.fillRect(x + velX, y + velY, 25, 25);
    }
}
