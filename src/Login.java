import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import javax.swing.JPanel;

public class Login extends JFrame {

    Login() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(438, 720);
        this.setResizable(false);
        this.setLayout(new GridLayout(1, 1));
        this.setTitle("O CLOCK");

        // logo wrapper
        JPanel logoWrapper = new JPanel();
        ImageIcon image = new ImageIcon("assets/logo.png");
        JLabel label = new JLabel();
        label.setIcon(image);
        logoWrapper.setBackground(Color.decode("#171515"));
        this.setIconImage(image.getImage());
        logoWrapper.add(label);

        JPanel formWrapper = new JPanel(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        // username////////////////////
        JLabel usernameLabel = new JLabel("USERNAME");
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        JTextField usernameTextField = new JTextField();
        usernameTextField.setBackground(Color.decode("#113b54"));
        usernameTextField.setForeground(Color.WHITE);

        usernameTextField.setPreferredSize(new Dimension(338, 30));
        // password//////////////////
        JLabel passwordLabel = new JLabel("PASSWORD");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBackground(Color.decode("#113b54"));
        passwordField.setForeground(Color.WHITE);
        passwordField.setPreferredSize(new Dimension(338, 30));
        // loginbtn////////////////////////
        JButton loginBtn = new JButton("LOGIN");
        loginBtn.setFocusable(false);
        loginBtn.setBackground(Color.decode("#545454"));
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setPreferredSize(new Dimension(100, 40));

        formWrapper.setBackground(Color.decode("#171515"));

        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weighty = 1;
        formWrapper.add(usernameLabel, gc);

        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.weighty = 1;
        gc.gridx = 0;
        gc.gridy = 1;
        formWrapper.add(usernameTextField, gc);

        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.gridx = 0;
        gc.gridy = 2;
        formWrapper.add(passwordLabel, gc);

        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.gridx = 0;
        gc.gridy = 3;
        formWrapper.add(passwordField, gc);

        gc.weighty = 10;
        gc.anchor = GridBagConstraints.CENTER;
        gc.gridx = 0;
        gc.gridy = 4;
        formWrapper.add(loginBtn, gc);

        JPanel container = new JPanel(new GridBagLayout());
        container.setBackground(Color.decode("#171515"));

        GridBagConstraints c = new GridBagConstraints();

        c.weighty = 0.4;
        c.gridx = 0;
        c.gridy = 0;
        container.add(logoWrapper, c);

        // c.weightx = 0.5;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.fill = GridBagConstraints.VERTICAL;
        c.weighty = 0.6;
        c.gridx = 0;
        c.gridy = 1;
        container.add(formWrapper, c);

        this.add(container);
        this.setVisible(true);

    }
}
