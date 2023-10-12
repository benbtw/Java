package Main;

import javax.swing.*;

public class Window {

    public Window(){
        JFrame frame = new JFrame("Game");
        Panel panel = new Panel();
        frame.setSize(640,480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

}
