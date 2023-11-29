package com.main;

import com.sim2d.engine.FPSClock;
import com.sim2d.engine.Window;

import javax.swing.*;
import java.awt.*;
public class Game extends JPanel implements Runnable {

    FPSClock clock;
    Thread gameThread;
    Player player = new Player();
    int dt = 0;

    public void init() {
        Window window = Window.getInstance();
        clock = new FPSClock(60);
        window.setTitle("Your Game");
        window.Size(640,480);
        window.Resizable(false);
        window.init();
        start();
    }

    public void start(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while(gameThread != null)
        {
            //updates here ie player.update(dt)
            player.update(dt);
            repaint();
            dt = clock.tick();
        }
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        //drawing here ie player.draw(g)
        player.draw(g);
    }
}
