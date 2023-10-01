package main;

import javax.swing.*;

public class GameWindow {
    public GameWindow(GamePanel gamePanel) {
        JFrame jframe = new JFrame();
        jframe.setSize(400,400);
        jframe.add(gamePanel);
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
