package main;

import javax.swing.*;
import java.awt.*;

public class Game extends JPanel {

    public Game() {
        JFrame frame = new JFrame("Game");
        frame.add(new Game());
        frame.setSize(640, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paint(g);
        g.fillRect(100,100,100,100);
    }
}
