package com.game;

import javax.swing.*;
import java.io.IOException;

public class Window extends JFrame {

    public Window() throws IOException {
        JFrame frame = new JFrame("Platformer");
        GameManager gm = new GameManager();
        frame.setSize(640, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(gm);
        frame.addKeyListener(new KeyHandler());
        frame.setFocusable(true);
        frame.setVisible(true);
        gm.Run();
    }
}
