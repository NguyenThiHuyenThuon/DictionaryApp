import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Button2 extends JFrame {
    JButton exit;
    JButton addButton;
    JTextField word;
    JTextField mean;

    JTextField pronouce;
    JTextField type;
    JLabel re;
    JLabel re1;
    JLabel re2;
    private static Image scaleImage(Image image, int w, int h) {
        Image scaled = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return scaled;
    }
    public Button2() throws FileNotFoundException {
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


        JButton exit2 = new JButton(scalIcon);
        exit2.setForeground(new Color(0,0,0));
        exit2.setBounds(5,5,50,30);
        add(exit2);
        exit2.setVisible(false);

        ImageIcon addIcon = new ImageIcon("C:\\Users\\User\\IdeaProjects\\project\\src\\addIcon.png");
        Image scale = scaleImage(addIcon.getImage(), 45,25);
        ImageIcon scaleIcon = new ImageIcon(scale);
        addButton = new JButton(scaleIcon);
        addButton.setBounds(527,5,50,30);
        add(addButton);


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




        re = new JLabel("Error!");
        re.setFont(new Font("Arial",1,40));
        re.setBounds(250,200,300,90);
        add(re);
        re.setVisible(false);

        re1 = new JLabel("This word's already existed!");
        re1.setFont(new Font("Arial",1,35));
        re1.setBounds(50,200,500,90);
        add(re1);
        re1.setVisible(false);

        re2 = new JLabel("Add Success!");
        re2.setFont(new Font("Arial",1,40));
        re2.setBounds(150,200,300,90);
        add(re2);
        re2.setVisible(false);

        addButton.addActionListener(e -> {
            addButton.setVisible(false);
            panel.setVisible(false);
            panel2.setVisible(false);
            panel3.setVisible(false);
            panel4.setVisible(false);
            exit2.setVisible(true);
            exit.setVisible(false);
        });
        exit.addActionListener(e->{
            re.setVisible(false);
            re1.setVisible(false);
            re2.setVisible(false);
            panel.setVisible(true);
            panel2.setVisible(true);
            panel3.setVisible(true);
            panel4.setVisible(true);
        });
        exit2.addActionListener(e -> {
            word.setText("");
            type.setText("");
            pronouce.setText("");
            mean.setText("");
            re.setVisible(false);
            re1.setVisible(false);
            re2.setVisible(false);
            addButton.setVisible(true);
            panel.setVisible(true);
            panel2.setVisible(true);
            panel3.setVisible(true);
            panel4.setVisible(true);
            exit.setVisible(true);
            exit2.setVisible(false);
        });


    }


}
