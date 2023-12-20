import javax.swing.*;

public class LoginPanel extends JPanel {

    public LoginPanel()
    {
        setLayout(new GroupLayout(this));
        CustomButton cb = new CustomButton();
        cb.setBounds(200, 200, 100, 50);
        cb.setText("My Button");
        cb.setFocusPainted(false);
        this.add(cb);
    }
}
