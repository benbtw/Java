package com.game;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameManager extends JPanel {

    int FPS = 60;
    Player player = new Player();
    TileMap map = new TileMap();

    public GameManager() throws IOException {
    }

    public void Run()
    {
        double drawInterval = 1000000000.0 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(true)
        {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1)
            {
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if(timer >= 1000000000)
            {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update()
    {
        player.update(map.tileRecs);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        map.draw(g);
        player.draw(g);
    }
}
