import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import javax.swing.JPanel;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Welcome extends JFrame {
    String username;
    JLabel welcomeUsername;

    Welcome() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(438, 720);
        this.setResizable(false);
        this.setLayout(new GridBagLayout());
        this.setTitle("O CLOCK");
        this.getContentPane().setBackground(Color.decode("#171515"));

        ImageIcon person = new ImageIcon("assets/person-icon.png");
        JLabel personIcon = new JLabel();
        personIcon.setIcon(person);
        

        JLabel welcomeMessage = new JLabel("Welcome");
        welcomeMessage.setFont(new Font("SansSerif", Font.PLAIN, 48));
        welcomeMessage.setForeground(Color.WHITE);
        
        welcomeUsername = new JLabel();
        welcomeUsername.setFont(new Font("SansSerif", Font.PLAIN, 48));
        welcomeUsername.setForeground(Color.decode("#7ab3d4"));
        

        JButton btn = new JButton("START");
        btn.setFont(new Font("DialogInput", Font.PLAIN, 30));
        btn.setFocusable(false);
        btn.setBackground(Color.decode("#545454"));
        btn.setForeground(Color.WHITE);
        btn.setPreferredSize(new Dimension(248, 48));

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weighty = 0.2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(personIcon, gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weighty = 0.1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(welcomeMessage, gbc);
        
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weighty = 0.1;
        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(welcomeUsername, gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weighty = 3;
        gbc.gridx = 0;
        gbc.gridy = 3;
        this.add(btn, gbc);

        btn.addActionListener(e ->  {
            dispose();
            Help helpScene = new Help();
            helpScene.setUsername(username);
        });

        this.setVisible(true);
    }

    public void setUsername(String username) {
        this.username = username;
        System.out.println(this.username);
        welcomeUsername.setText(username + "!");
    }
}
