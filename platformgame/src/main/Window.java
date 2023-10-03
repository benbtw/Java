package main;

import javax.swing.*;

public class Window {

    public Window() {
        JFrame frame = new JFrame();
        Panel panel = new Panel();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setSize(1280,720);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
