import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import javax.swing.JPanel;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Signup extends JFrame implements MouseListener{
    JLabel loginLabel;
    String username;
    String password;

    Signup() {

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
        // signupBtn////////////////////////
        JButton signupBtn = new JButton("SIGNUP");
        signupBtn.setFocusable(false);
        signupBtn.setBackground(Color.decode("#545454"));
        signupBtn.setForeground(Color.WHITE);
        signupBtn.setPreferredSize(new Dimension(100, 40));

        loginLabel = new JLabel("Already have an account? Log In");
        loginLabel.setForeground(Color.WHITE);
        loginLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        loginLabel.addMouseListener(this);


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
        formWrapper.add(signupBtn, gc);

        gc.anchor = GridBagConstraints.LAST_LINE_START;
        gc.weighty = 10;
        gc.gridx = 0;
        gc.gridy = 5;
        formWrapper.add(loginLabel, gc);

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

        signupBtn.addActionListener(e -> { 
                try { 
                    username = usernameTextField.getText().toString();
                    password = passwordField.getText().toString();

                    BufferedWriter writer = new BufferedWriter(new FileWriter("accounts.csv", true));
                    writer.write(username + "\t" + password + "\n");
                    writer.close();
                    JOptionPane.showMessageDialog(null, "registration complete", "Registration", JOptionPane.INFORMATION_MESSAGE);

                } catch(IOException error) {
                    error.printStackTrace();
                }
           
        });

        this.add(container);
        this.setVisible(false);

       
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == loginLabel) {
            setVisible(false);
            Login frame = new Login();
            frame.setVisible(true);
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
}
