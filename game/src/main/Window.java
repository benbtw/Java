package main;

import javax.swing.*;

public class Window {
    public Window() {
        JFrame frame = new JFrame("Game");
        frame.setSize(640, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
