package Main;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel implements Runnable {

    Timer timer;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.fillRect(10,10,10,10);
    }


    @Override
    public void run() {
        while (true){
            repaint ();
            try {
                timer.wait(17);
            } catch (InterruptedException e) {
                System.out.println("FPS Drop");
            }
        }
    }
}
