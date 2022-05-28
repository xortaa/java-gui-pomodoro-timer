import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class Login extends JFrame{

    Login() {
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(438, 720);
        this.setResizable(false);
        this.setLayout(new GridBagLayout());
        this.getContentPane().setBackground(Color.BLACK);

        // logo wrapper
        JPanel logoWrapper = new JPanel();
        ImageIcon image = new ImageIcon("assets/logo.png");
        JLabel label = new JLabel();
        label.setIcon(image);
        logoWrapper.setBackground(Color.BLACK);
        this.setIconImage(image.getImage());
        logoWrapper.add(label);


        JPanel formWrapper = new JPanel(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        //username////////////////////
        JLabel usernameLabel = new JLabel("USERNAME");
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        usernameLabel.setBackground(Color.RED);
        JTextField usernameTextField = new JTextField();
        usernameTextField.setText("username");
        //password//////////////////
        JLabel passwordLabel = new JLabel("PASSWORD");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        JTextField passwordTextField = new JTextField();
        //loginbun////////////////////////
        JButton loginBtn = new JButton("LOGIN");
        loginBtn.setPreferredSize(new Dimension(30, 30));
        formWrapper.add(usernameLabel);
        formWrapper.add(usernameTextField);
        formWrapper.add(passwordLabel);
        formWrapper.add(passwordTextField);
        formWrapper.add(loginBtn);
        formWrapper.setBackground(Color.BLACK);
        
        gc.weightx = 0.5;
        gc.weighty = 0.5;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 0; 
        gc.gridy = 0;
        formWrapper.add(usernameLabel, gc);

        gc.gridx = 0;
        gc.gridy = 1; 
        formWrapper.add(usernameTextField, gc);

        gc.gridx = 0; 
        gc.gridy = 2; 
        formWrapper.add(passwordLabel, gc);
        
        gc.gridx = 0;
        gc.gridy = 3; 
        formWrapper.add(passwordTextField, gc);

        gc.gridx = 0;
        gc.gridy = 4; 
        formWrapper.add(loginBtn, gc);



        JPanel container = new JPanel(new GridLayout(2,1,0 ,20));
        container.setBackground(Color.BLACK);
        container.add(logoWrapper);
        container.add(formWrapper);
        
        
        
        this.add(container);
        this.setVisible(true);

        
        
    }
}
