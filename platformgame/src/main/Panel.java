package main;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    @Override
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawRect(100,100,100,100);
    }
}
