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
        setBounds(350, 100,600, 800);
        setLayout(null);

        JLabel label = new JLabel("Welcome to my app!");
        label.setBounds(130,70,300,90);
        label.setFont(new Font("Arial",1,30));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(label);
        setForeground(new Color(0,0,0));

        button1 = new JButton("Exit");
        button1.setBounds(180,200,200,40);
        button1.setFont(new Font("Cooper", 1, 14));
        add(button1);


        button2 = new JButton("Add");
        button2.setFont(new Font("Cooper", 1, 14));
        button2.setBounds(180,200+50,200,40);
        add(button2);

        button3 = new JButton("Remove");
        button3.setFont(new Font("Cooper", 1, 14));
        button3.setBounds(180,250+50,200,40);
        add(button3);

        button4 = new JButton("Update");
        button4.setFont(new Font("Cooper", 1, 14));
        button4.setBounds(180,300+50,200,40);
        add(button4);

        button5 = new JButton("Display");
        button5.setFont(new Font("Cooper", 1, 14));
        button5.setBounds(180,350+50,200,40);
        add(button5);

        button6 = new JButton("Search");
        button6.setFont(new Font("Cooper", 1, 14));
        button6.setBounds(180,400+50,200,40);
        add(button6);

        button8 = new JButton("Game");
        button8.setFont(new Font("Cooper", 1, 14));
        button8.setBounds(180,450+50,200,40);
        add(button8);

        button9 = new JButton("Export to file");
        button9.setFont(new Font("Cooper", 1, 14));
        button9.setBounds(180,500+50,200,40);
        add(button9);



        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JButton getButton1() {
        return button1;
    }

    public void setButton1(JButton button1) {
        this.button1 = button1;
    }

    public JButton getButton2() {
        return button2;
    }

    public void setButton2(JButton button2) {
        this.button2 = button2;
    }

    public JButton getButton3() {
        return button3;
    }

    public void setButton3(JButton button3) {
        this.button3 = button3;
    }

    public JButton getButton4() {
        return button4;
    }

    public void setButton4(JButton button4) {
        this.button4 = button4;
    }

    public JButton getButton5() {
        return button5;
    }

    public void setButton5(JButton button5) {
        this.button5 = button5;
    }

    public JButton getButton6() {
        return button6;
    }

    public void setButton6(JButton button6) {
        this.button6 = button6;
    }

    public JButton getButton7() {
        return button7;
    }

    public void setButton7(JButton button7) {
        this.button7 = button7;
    }

    public JButton getButton8() {
        return button8;
    }

    public void setButton8(JButton button8) {
        this.button8 = button8;
    }

    public JButton getButton9() {
        return button9;
    }

    public void setButton9(JButton button9) {
        this.button9 = button9;
    }
}



