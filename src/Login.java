import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import javax.swing.JPanel;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

// import org.w3c.dom.events.MouseEvent;

public class Login extends JFrame implements MouseListener {
    JLabel signupLabel;
    String username;
    String password;
    boolean allow = false;

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

        signupLabel = new JLabel("Don't have an account? Sign up");
        signupLabel.setForeground(Color.WHITE);
        signupLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        signupLabel.addMouseListener(this);

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

        gc.weighty = 3;
        gc.anchor = GridBagConstraints.CENTER;
        gc.gridx = 0;
        gc.gridy = 4;
        formWrapper.add(loginBtn, gc);

        gc.anchor = GridBagConstraints.LAST_LINE_START;
        gc.weighty = 10;
        gc.gridx = 0;
        gc.gridy = 5;
        formWrapper.add(signupLabel, gc);

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

        loginBtn.addActionListener(e -> {
            try {
                allow = false;
                username = usernameTextField.getText().toString();
                password = passwordField.getText().toString();

                FileReader fr = new FileReader("accounts.csv");
                BufferedReader br = new BufferedReader(fr);
                String line = br.readLine();
                while (line != null) {
                    if (line.equals(username + "\t" + password));
                    allow = true;
                    break;
                }
                fr.close();
            } catch (IOException error) {
                error.printStackTrace();
            }

        });

        this.add(container);
        this.setVisible(true);

    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == signupLabel) {
            setVisible(false);
            Signup frame = new Signup();
            frame.setVisible(true);
        }

    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub

    }
}
