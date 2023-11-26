import javax.swing.*;
import java.awt.*;

public class Button4 extends JFrame {

    frame1 frame1 = new frame1();
    frame2 frame2 = new frame2();

    frame3 frame3 = new frame3();

    private static Image scaleImage(Image image, int w, int h) {
        Image scaled = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return scaled;
    }
    public Button4() {

        frame2.addButton.addActionListener(e -> {
            frame2.mean.setText("");
            frame2.type.setText("");
            frame2.word.setText("");
            frame2.pronouce.setText("");
        });
        frame2.exit.addActionListener(e -> {
            frame1.setVisible(true);
            frame2.setVisible(false);
        });

        frame3.exit.addActionListener(e -> {
            frame1.setVisible(true);
            frame3.setVisible(false);
        });
    }
}

class frame extends JFrame {
    JButton exit;
    JButton addButton;

    private static Image scaleImage(Image image, int w, int h) {
        Image scaled = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return scaled;
    }
    public frame() {

        setTitle("DictionaryApp");
        getContentPane().setBackground(new Color(167, 217, 181));
        setBounds(350, 100,600, 800);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon exitIcon = new ImageIcon("C:\\Users\\User\\IdeaProjects\\project\\src\\ex.png");
        Image scal = scaleImage(exitIcon.getImage(), 50, 30);
        ImageIcon scalIcon = new ImageIcon(scal);
        exit = new JButton(scalIcon);
        exit.setForeground(new Color(0,0,0));
        exit.setBounds(5,5,50,30);
        add(exit);

        ImageIcon addIcon = new ImageIcon("C:\\Users\\User\\IdeaProjects\\project\\src\\addIcon.png");
        Image scale = scaleImage(addIcon.getImage(), 45,25);
        ImageIcon scaleIcon = new ImageIcon(scale);
        addButton = new JButton(scaleIcon);
        addButton.setBounds(527,5,50,30);
        add(addButton);


    }
}

class frame1 extends frame {
    JTextField w;
    public frame1() {

        JLabel l = new JLabel("Please type the word you want to update:");
        l.setFont(new Font("Arial",1,20));
        l.setBounds(100,100,400,30);
        add(l);

        w = new JTextField();
        w.setBounds(220,150,120,30);
        w.setFont(new Font("Segoe UI Black", 2, 15));
        add(w);

        setVisible(false);
    }

}

class frame2 extends frame {
    JTextField word;
    JTextField mean;

    JTextField pronouce;
    JTextField type;
    public frame2() {
        JLabel label = new JLabel("  Word:    ");
        label.setFont(new Font("Segoe UI Black", 2, 20));
        label.setBounds(30,70+30,200,20);

        word = new JTextField(25);
        word.setFont(new Font("Arial",3,14));
        word.setBackground(Color.WHITE);
        word.setEditable(true);

        JLabel label1 = new JLabel("Meaning: ");
        label1.setFont(new Font("Segoe UI Black", 2, 20));
        label1.setBounds(30,320+60,200,20);

        mean = new JTextField(25);
        mean.setFont(new Font("Arial",3,14));
        mean.setBackground(Color.WHITE);
        mean.setEditable(true);


        JLabel label2 = new JLabel("   Type:    ");
        label2.setFont(new Font("Segoe UI Black", 2, 20));
        label2.setBounds(30,150+40,200,20);

        type = new JTextField(25);
        type.setFont(new Font("Arial",3,14));
        type.setBackground(Color.WHITE);
        type.setEditable(true);

        JLabel label3 = new JLabel("Pronouce:");
        label3.setFont(new Font("Segoe UI Black", 2, 20));
        label3.setBounds(30,240+50,200,20);

        pronouce = new JTextField(25);
        pronouce.setFont(new Font("Arial",3,14));
        pronouce.setBackground(Color.WHITE);
        pronouce.setEditable(true);

        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();

        panel3.setBackground(new Color(167, 217, 181));
        panel4.setBackground(new Color(167, 217, 181));
        panel2.setBackground(new Color(167, 217, 181));
        panel.setBackground(new Color(167, 217, 181));

        panel4.setBounds(0,240+30,600,40);
        panel3.setBounds(0,150+20,600,40);
        panel2.setBounds(0,320+40,600,500);
        panel.setBounds(0,70+10,600,40);

        panel.add(label);
        panel.add(word);
        panel2.add(label1);
        panel2.add(mean);
        panel3.add(label2);
        panel3.add(type);
        panel4.add(label3);
        panel4.add(pronouce);
        add(panel);
        add(panel2);
        add(panel3);
        add(panel4);

        setVisible(false);
    }
}

class frame3 extends frame {
    JLabel re;
    JLabel re2;
    public frame3() {

        addButton.setVisible(false);

        re = new JLabel("Error!");
        re.setFont(new Font("Arial",1,40));
        re.setBounds(220,200,300,90);
        add(re);
        re.setVisible(false);


        re2 = new JLabel("Update Success!");
        re2.setFont(new Font("Arial",1,40));
        re2.setBounds(130,200,400,90);
        add(re2);
        re2.setVisible(false);

        setVisible(false);
    }

}