package com.sim2d.engine;

import com.main.Game;
import com.main.Player;

import javax.swing.*;

public class Window extends JFrame {

    private String title;
    private int width, height;
    JFrame frame;
    private static Window window_instance =  null;

    public static synchronized Window getInstance()
    {
        if(window_instance == null)
            window_instance = new Window();

        return window_instance;
    }

    public Window()
    {
        frame = new JFrame();
    }

    public void init() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(new Game());
        frame.addKeyListener(new KeyHandler());
        frame.setFocusable(true);
        frame.setVisible(true);
    }

    public void Resizable(boolean value)
    {
        frame.setResizable(value);
    }

    public void Size(int w, int h)
    {
        this.width = w;
        this.height = h;
        frame.setSize(w, h);
    }

    public void setTitle(String title) {
        frame.setTitle(title);
    }
}
