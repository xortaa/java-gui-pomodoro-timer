import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;

import java.awt.event.*;
import java.awt.Color;
import javax.swing.JPanel;

public class JohnS extends JFrame implements ActionListener {

    JLabel counterLabel;
    JPanel countdownWrapper, buttonWrapper;
    JButton work, rest, reset;
    Font font1 = new Font("Arial", Font.PLAIN, 70);
    Timer timer;
    int second, minute;
    String ddSecond, ddMinute;
    DecimalFormat dFormat = new DecimalFormat("00");
    boolean bool1 = false;
    boolean bool2 = false;
    String username;

    public JohnS() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("O CLOCK");
        this.setSize(438, 720);
        this.setResizable(false);
        this.setLayout(new GridBagLayout());
        this.getContentPane().setBackground(Color.decode("#171515"));

        // NAV PANEL ///////////////////////////
        JPanel navContainer = new JPanel(new GridBagLayout());
        ImageIcon timer = new ImageIcon("assets/timer.png");
        ImageIcon search = new ImageIcon("assets/search.png");
        JLabel timerIcon = new JLabel();
        timerIcon.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mousePressed(MouseEvent click) {
                
            }
        });
        timerIcon.setIcon(timer);
        JLabel searchIcon = new JLabel();
        searchIcon.setIcon(search);
        searchIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent click) {
                dispose();
                Help helpScene = new Help();
                helpScene.setUsername(username);
            }
        });

        GridBagConstraints nav = new GridBagConstraints();
        nav.weighty = 0.5;
        nav.gridx = 0;
        nav.gridy = 0;
        navContainer.add(timerIcon, nav);

        nav.weighty = 0.5;
        nav.gridx = 0;
        nav.gridy = 1;
        navContainer.add(searchIcon, nav);

        // COUNTER PANEL///////////////
        JPanel timerContainer = new JPanel(new GridBagLayout());
        timerContainer.setBorder(BorderFactory.createMatteBorder(0, 3, 0, 0, Color.decode("#113b54")));
        timerContainer.setBackground(Color.decode("#171515"));
        JLabel title = new JLabel("POMODORO TIMER");
        title.setFont(new Font("Serif", Font.PLAIN, 25));
        title.setForeground(Color.WHITE);
        countdownWrapper = new JPanel(new GridLayout(1, 1));
        countdownWrapper.setBackground(Color.decode("#171515"));
        counterLabel = new JLabel("");
        counterLabel.setHorizontalAlignment(JLabel.CENTER);
        counterLabel.setFont(font1);
        counterLabel.setForeground(Color.decode("#113c56"));
        counterLabel.setText("00:00");
        countdownWrapper.add(counterLabel);
        timerContainer.add(countdownWrapper);
        // BUTTONS //////////////////////////
        buttonWrapper = new JPanel(new FlowLayout());
        buttonWrapper.setBackground(Color.decode("#171515"));
        work = new JButton("WORK");
        work.setPreferredSize(new Dimension(130, 50));
        rest = new JButton("REST");
        rest.setPreferredSize(new Dimension(130, 50));
        reset = new JButton("RESET");
        reset.setPreferredSize(new Dimension(130, 50));
        work.addActionListener(this);
        rest.addActionListener(this);
        reset.addActionListener(this);
        buttonWrapper.add(work);
        buttonWrapper.add(rest);
        buttonWrapper.add(reset);
        timerContainer.add(buttonWrapper);
        buttonWrapper.add(work);
        buttonWrapper.add(rest);
        buttonWrapper.add(reset);

        GridBagConstraints timerConstraints = new GridBagConstraints();

        timerConstraints.weighty = 0.1;
        timerConstraints.gridx = 0;
        timerConstraints.gridy = 0;
        timerConstraints.anchor = GridBagConstraints.CENTER;
        timerContainer.add(title, timerConstraints);

        timerConstraints.weighty = 0.6;
        timerConstraints.weightx = 1;
        timerConstraints.gridx = 0;
        timerConstraints.gridy = 1;
        timerConstraints.anchor = GridBagConstraints.PAGE_END;
        timerConstraints.fill = GridBagConstraints.BOTH;
        timerContainer.add(countdownWrapper, timerConstraints);

        timerConstraints.weighty = 0.3;
        timerConstraints.gridx = 0;
        timerConstraints.gridy = 2;
        timerConstraints.fill = GridBagConstraints.BOTH;
        timerContainer.add(buttonWrapper, timerConstraints);

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
        this.add(timerContainer, gbc);

        this.setVisible(true);

    }

    public void countdownTimer() {

        timer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                second--;
                ddSecond = dFormat.format(second);
                ddMinute = dFormat.format(minute);
                counterLabel.setText(ddMinute + ":" + ddSecond);

                if (second == -1) {
                    second = 59;
                    minute--;
                    ddSecond = dFormat.format(second);
                    ddMinute = dFormat.format(minute);
                    counterLabel.setText(ddMinute + ":" + ddSecond);
                }
                if (minute == 0 && second == 0) {
                    timer.stop();
                    JOptionPane.showMessageDialog(null, "Time's up!", "error", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    public void setUsername(String username)  {
        this.username = username;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == rest) {
            try {
                timer.stop();
                counterLabel.setText("05:00");
                second = 0;
                minute = 5;
                countdownTimer();
                timer.start();
            } catch (NullPointerException npe) {
                counterLabel.setText("05:00");
                second = 0;
                minute = 5;
                countdownTimer();
                timer.start();
            }
        } else if (e.getSource() == work) {
            try {
                timer.stop();
                counterLabel.setText("25:00");
                second = 0;
                minute = 25;
                countdownTimer();
                timer.start();
            } catch (NullPointerException npe) {
                counterLabel.setText("25:00");
                second = 0;
                minute = 25;
                countdownTimer();
                timer.start();
            }
        } else if (e.getSource() == reset) {
            try {
                timer.stop();
                counterLabel.setText("00:00");
            } catch (NullPointerException npe) {
                counterLabel.setText("00:00");
            }
        }
    }

}