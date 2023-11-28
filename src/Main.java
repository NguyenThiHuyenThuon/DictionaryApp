import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

public class Main extends JFrame {

    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    JButton button8;
    JButton button9;

    public Main() {
        setTitle("DictionaryApp");
        getContentPane().setBackground(new Color(167, 217, 181));
        setBounds(350, 100, 600, 800);
        setLayout(null);

        JLabel label = new JLabel("Welcome to my app!");
        label.setBounds(130, 70, 300, 90);
        label.setFont(new Font("Arial", 1, 30));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(label);
        setForeground(new Color(0, 0, 0));

        button1 = new JButton("Exit");
        button1.setBounds(180, 200, 200, 40);
        button1.setFont(new Font("Cooper", 1, 14));
        add(button1);


        button2 = new JButton("Add");
        button2.setFont(new Font("Cooper", 1, 14));
        button2.setBounds(180, 200 + 50, 200, 40);
        add(button2);

        button3 = new JButton("Remove");
        button3.setFont(new Font("Cooper", 1, 14));
        button3.setBounds(180, 250 + 50, 200, 40);
        add(button3);

        button4 = new JButton("Update");
        button4.setFont(new Font("Cooper", 1, 14));
        button4.setBounds(180, 300 + 50, 200, 40);
        add(button4);

        button5 = new JButton("Display");
        button5.setFont(new Font("Cooper", 1, 14));
        button5.setBounds(180, 350 + 50, 200, 40);
        add(button5);

        button6 = new JButton("Search");
        button6.setFont(new Font("Cooper", 1, 14));
        button6.setBounds(180, 400 + 50, 200, 40);
        add(button6);

        button7 = new JButton("Text Translation");
        button7.setFont(new Font("Cooper", 1, 14));
        button7.setBounds(180, 450 + 50, 200, 40);
        add(button7);

        button8 = new JButton("Game");
        button8.setFont(new Font("Cooper", 1, 14));
        button8.setBounds(180, 500 + 50, 200, 40);
        add(button8);

        button9 = new JButton("Export to file");
        button9.setFont(new Font("Cooper", 1, 14));
        button9.setBounds(180, 550 + 50, 200, 40);
        add(button9);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}