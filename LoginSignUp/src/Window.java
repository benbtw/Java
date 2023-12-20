import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window(){
        setTitle("Login | Sign Up Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        add(new LoginPanel());
        setVisible(true);
    }
}
