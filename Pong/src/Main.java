import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    static JFrame frame = new JFrame("Pong");
    public static void main(String[] args) {
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640,495);
        frame.setLocationRelativeTo(null);

        PongGame game = new PongGame();
        frame.add(game);
        frame.setVisible(true);

        Timer timer = new Timer(17, e -> {
            game.gameLogic();
            game.repaint();
        });

        timer.start();
    }
}
