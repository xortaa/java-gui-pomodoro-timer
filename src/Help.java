import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import javax.swing.JPanel;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Help extends JFrame {
    String username;
    JLabel welcomeUsername = new JLabel();
    String[] result = {};
    String[] faqContent = { "how to use the timer?", "what is the pomodoro technique?",
            "how to navigate back to the timer?", "about" };
    String[] helpContent = {
            "To use the timer click the timer icon to navigate to the timer\nClick the WORK button for a 25 min countdown\nClick the REST button for a 5 min timer\nClick the RESET button to reset the timer to 0",
            "The Pomodoro Technique is a time management method for students, perfectionists,\n and procrastinators of all kinds. Work in focused, 25-minute intervals\n with a 5min rest between.",
            "Click the timer icon to navigate to the timer ",
            "This app is the final project for ICS2606 Computer Programming and IT2622 Human Computer Intereaction\nGroup Members: \nKercwin Ocampo (Lead Developer)\nFranceska Flores\nJohn Ancheta"
    };

    Help() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(438, 720);
        this.setResizable(false);
        this.setLayout(new GridBagLayout());
        this.setTitle("O CLOCK");
        this.getContentPane().setBackground(Color.decode("#171515"));
        // aside panel ///////////////////////
        JPanel navContainer = new JPanel(new GridBagLayout());
        GridBagConstraints nav = new GridBagConstraints();
        ImageIcon timer = new ImageIcon("assets/timer.png");
        ImageIcon search = new ImageIcon("assets/search.png");
        JLabel timerIcon = new JLabel();
        timerIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent click) {
                dispose();
                JohnS timer = new JohnS();
                timer.setUsername(username);
            }
        });
        timerIcon.setIcon(timer);
        JLabel searchIcon = new JLabel();
        searchIcon.setIcon(search);
        searchIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent click) {
                
            }
        });

        nav.weighty = 0.5;
        nav.gridx = 0;
        nav.gridy = 0;
        navContainer.add(timerIcon, nav);

        nav.weighty = 0.5;
        nav.gridx = 0;
        nav.gridy = 1;
        navContainer.add(searchIcon, nav);

        // main panel //////////////////////////
        JPanel mainContainer = new JPanel(new GridBagLayout());
        GridBagConstraints main = new GridBagConstraints();
        mainContainer.setBackground(Color.decode("#171515"));
        mainContainer.setBorder(BorderFactory.createMatteBorder(0, 3, 0, 0, Color.decode("#113b54")));
        //////////////////////////////// WELCOME//////////////////
        welcomeUsername.setFont(new Font("SansSerif", Font.PLAIN, 30));
        welcomeUsername.setForeground(Color.decode("#77adce"));

        JLabel welcomeMessage = new JLabel("HOW CAN WE HELP?");
        welcomeMessage.setForeground(Color.WHITE);
        welcomeMessage.setFont(new Font("SansSerif", Font.PLAIN, 30));
        /////////////////////////////////// SEARCH/////////////

        ///////////////////////////////////////// FAQ///////////////////
        JLabel faq = new JLabel("FAQ");
        faq.setFont(new Font("SansSerif", Font.PLAIN, 20));
        faq.setForeground(Color.WHITE);

        JPanel faqContainer = new JPanel(new GridLayout(4, 1, 0, 30));
        faqContainer.setBackground(Color.decode("#171515"));

        JPanel faqWrapper1 = new JPanel(new GridLayout(1, 1, 0, 20));
        faqWrapper1.setBackground(Color.decode("#113b54"));
        faqWrapper1.setPreferredSize(new Dimension(320, 80));
        JLabel faq1 = new JLabel(faqContent[0]);
        faq1.setFont(new Font("SansSerif", Font.PLAIN, 20));
        faq1.setForeground(Color.WHITE);
        faqWrapper1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent click) {
                JOptionPane.showMessageDialog(null, helpContent[0], faqContent[0],
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        faqWrapper1.add(faq1);

        JPanel faqWrapper2 = new JPanel(new GridLayout(1, 1, 0, 20));
        faqWrapper2.setBackground(Color.decode("#113b54"));
        faqWrapper2.setPreferredSize(new Dimension(320, 80));
        JLabel faq2 = new JLabel(faqContent[1]);
        faq2.setFont(new Font("SansSerif", Font.PLAIN, 20));
        faq2.setForeground(Color.WHITE);
        faqWrapper2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent click) {
                JOptionPane.showMessageDialog(null, helpContent[1], faqContent[1],
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        faqWrapper2.add(faq2);

        JPanel faqWrapper3 = new JPanel(new GridLayout(1, 1, 0, 20));
        faqWrapper3.setBackground(Color.decode("#113b54"));
        faqWrapper3.setPreferredSize(new Dimension(320, 80));
        JLabel faq3 = new JLabel(faqContent[2]);
        faq3.setFont(new Font("SansSerif", Font.PLAIN, 20));
        faq3.setForeground(Color.WHITE);
        faqWrapper3.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent click) {
                JOptionPane.showMessageDialog(null, helpContent[2], faqContent[2],
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        faqWrapper3.add(faq3);

        JPanel faqWrapper4 = new JPanel(new GridLayout(1, 1, 0, 20));
        faqWrapper4.setBackground(Color.decode("#113b54"));
        faqWrapper4.setPreferredSize(new Dimension(320, 80));
        JLabel faq4 = new JLabel(faqContent[3]);
        faq4.setFont(new Font("SansSerif", Font.PLAIN, 20));
        faq4.setForeground(Color.WHITE);
        faqWrapper4.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent click) {
                JOptionPane.showMessageDialog(null, helpContent[3], faqContent[3],
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        faqWrapper4.add(faq4);

        faqContainer.add(faqWrapper1);
        faqContainer.add(faqWrapper2);
        faqContainer.add(faqWrapper3);
        faqContainer.add(faqWrapper4);

        /////////////////////////////// SEARCH BAR////////////////////////////
        JPanel searchContainer = new JPanel(new FlowLayout());
        JTextField searchField = new JTextField();
        searchField.setFont(new Font("SansSerif", Font.PLAIN, 20));
        searchField.setPreferredSize(new Dimension(280, 30));
        searchField.setBackground(Color.decode("#545454"));
        searchField.setForeground(Color.WHITE);
        JButton searchButton = new JButton();
        ImageIcon magnifyingIcon = new ImageIcon("assets/magnifying-glass.png");
        searchButton.setIcon(magnifyingIcon);
        searchButton.setBackground(Color.decode("#78b0d1"));
        searchButton.setPreferredSize(new Dimension(40, 30));
        searchButton.addActionListener(e -> {

            String searchInput = searchField.getText();
            String[] result = null;

            result = Stream.of(faqContent).filter(str -> str.startsWith(searchInput))
                    .collect(Collectors.toSet()).toArray(new String[0]);

            if (!Arrays.asList(result).contains(faqContent[0])) {
                faqContainer.remove(faqWrapper1);
            }
            if (!Arrays.asList(result).contains(faqContent[1])) {
                faqContainer.remove(faqWrapper2);
            }
            if (!Arrays.asList(result).contains(faqContent[2])) {
                faqContainer.remove(faqWrapper3);
            }
            if (!Arrays.asList(result).contains(faqContent[3])) {
                faqContainer.remove(faqWrapper4);
            }

            revalidate();
            repaint();

        });
        searchContainer.setBackground(Color.decode("#171515"));
        searchContainer.add(searchField);
        searchContainer.add(searchButton);

        /////////////////////////////// ADDING TO THE MAIN CONTAINER
        /////////////////////////////// ////////////////////////
        main.weighty = 0.1;
        main.gridx = 0;
        main.gridy = 0;
        mainContainer.add(welcomeUsername, main);

        main.weighty = 0.1;
        main.gridx = 0;
        main.gridy = 1;
        mainContainer.add(welcomeMessage, main);

        main.weighty = 0.2;
        main.gridx = 0;
        main.gridy = 2;
        mainContainer.add(searchContainer, main);

        main.weighty = 0.1;
        main.anchor = GridBagConstraints.LINE_START;
        main.gridx = 0;
        main.gridy = 3;
        mainContainer.add(faq, main);

        main.weighty = 2;
        main.gridx = 0;
        main.gridy = 4;
        main.anchor = GridBagConstraints.FIRST_LINE_START;
        main.fill = GridBagConstraints.VERTICAL;
        mainContainer.add(faqContainer, main);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.weightx = 0.1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(navContainer, gbc);

        gbc.weightx = 0.9;
        gbc.weighty = 1;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(mainContainer, gbc);

        this.setVisible(true);
    }

    public void setUsername(String username) {
        this.username = username;
        welcomeUsername.setText("Hi!" + " " + username);

    }

}
