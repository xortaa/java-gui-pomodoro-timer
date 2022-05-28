import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.*;

public class AppTimer extends JFrame implements ActionListener{
    JLabel counterLabel;
    JPanel panel1, panel2, panel3, panelExtra1, panelExtra2;
    JButton work, rest, reset;
    Font font1 = new Font("Arial", Font.PLAIN, 70);
    Timer timer;
    int second, minute;
    String ddSecond, ddMinute;
    DecimalFormat dFormat = new DecimalFormat("00");

    public AppTimer() {
        super("Pomodoro Timer");
        setSize(800,600);
        setLayout(new GridLayout(5, 1));

        panelExtra1 = new JPanel();
        add(panelExtra1);

        panel1 = new JPanel();
        counterLabel = new JLabel("");
        counterLabel.setBounds(300, 230, 200, 100);
        counterLabel.setHorizontalAlignment(JLabel.CENTER);
        counterLabel.setFont(font1);
        add(panel1);
        panel1.add(counterLabel);

        panelExtra2 = new JPanel();
        add(panelExtra2);

        /*GridLayout gl = new GridLayout(1,1);
        gl.setHgap(50);
        gl.setVgap(50);*/

        panel2 = new JPanel(new FlowLayout());
        work = new JButton("WORK");
        work.setPreferredSize(new Dimension(300,50));
        rest = new JButton("REST");
        rest.setPreferredSize(new Dimension(300,50));
        add(panel2);
        panel2.add(work);
        panel2.add(rest);

        panel3 = new JPanel(new FlowLayout());
        reset = new JButton("RESET");
        reset.setPreferredSize(new Dimension(200, 50));
        add(panel3);
        panel3.add(reset);

        setLocationRelativeTo(null);
        setVisible(true);

        counterLabel.setText("00:00");

        work.addActionListener(this);
        rest.addActionListener(this);
    }

    public static void main(String[] args) {
        AppTimer ct= new AppTimer();
        ct.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void countdownTimer() {

        timer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                second--;
                ddSecond = dFormat.format(second);
                ddMinute = dFormat.format(minute);
                counterLabel.setText(ddMinute + ":" + ddSecond);

                if(second==-1) {
                    second = 59;
                    minute--;
                    ddSecond = dFormat.format(second);
                    ddMinute = dFormat.format(minute);
                    counterLabel.setText(ddMinute + ":" + ddSecond);
                }
                if(minute==0 && second==0) {
                    timer.stop();
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == rest) {
            counterLabel.setText("05:00");
            second =0;
            minute =5;
            countdownTimer();
            timer.start();
        }
        else if(e.getSource() == work) {
            counterLabel.setText("25:00");
            second =5;
            minute =0;
            Boolean bool1 = (second == 0);
            Boolean bool2 = (minute == 0);
            if (bool1 && bool2) {
                JOptionPane.showMessageDialog(null, "Time's up!");
            }
            countdownTimer();
            timer.start();
        }
    }
}
