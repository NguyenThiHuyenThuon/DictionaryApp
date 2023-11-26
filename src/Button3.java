import javax.swing.*;
import java.awt.*;

public class Button3 extends JFrame {
    JButton exit;
    JButton deleteButton;
    JButton yesButton;
    JButton noButton;
    JTextField textField;
    JLabel re;
    JLabel re2;
    private static Image scaleImage(Image image, int w, int h) {
        Image scaled = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return scaled;
    }
    public Button3() {
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

        ImageIcon deleteIcon = new ImageIcon("C:\\Users\\User\\IdeaProjects\\project\\src\\deleteIcon.png");
        Image scale = scaleImage(deleteIcon.getImage(), 45,25);
        ImageIcon scaleIcon = new ImageIcon(scale);
        deleteButton = new JButton(scaleIcon);
        deleteButton.setBounds(527,5,50,30);
        add(deleteButton);

        JLabel label1 = new JLabel("Please type the word you want to delete:");
        label1.setFont(new Font("Arial",1,20));
        label1.setBounds(100,100,400,30);
        add(label1);

        textField = new JTextField();
        textField.setBounds(220,150,120,30);
        textField.setFont(new Font("Segoe UI Black", 2, 15));
        add(textField);

        JLabel label2 = new JLabel("ARE YOU SURE?");
        label2.setFont(new Font("Segoe UI Black", 2, 25));
        label2.setBounds(200,350,400,30);
        add(label2);
        label2.setVisible(false);

        yesButton = new JButton("YES");
        yesButton.setBounds(100,450,100,50);
        yesButton.setFont(new Font("Segoe UI Black", 2, 20));
        yesButton.setVisible(false);
        add(yesButton);

        noButton = new JButton("NO");
        noButton.setBounds(400,450,100,50);
        noButton.setFont(new Font("Segoe UI Black", 2, 20));
        noButton.setVisible(false);
        add(noButton);

        re = new JLabel("Error!");
        re.setFont(new Font("Arial",1,40));
        re.setBounds(250,200,300,90);
        add(re);
        re.setVisible(false);

        re2 = new JLabel("Delete Success!");
        re2.setFont(new Font("Arial",1,40));
        re2.setBounds(150,200,400,90);
        add(re2);
        re2.setVisible(false);

        deleteButton.setVisible(true);
        label1.setVisible(true);
        textField.setVisible(true);
        exit.setVisible(true);

        deleteButton.addActionListener(e -> {
            label2.setVisible(true);
            yesButton.setVisible(true);
            noButton.setVisible(true);
            textField.setEditable(false);
        });

        yesButton.addActionListener(e -> {
            textField.setText("");
            deleteButton.setVisible(false);
            label1.setVisible(false);
            exit2.setVisible(true);
            textField.setVisible(false);
            exit.setVisible(false);
            label2.setVisible(false);
            yesButton.setVisible(false);
            noButton.setVisible(false);
            textField.setEditable(true);
        });

        noButton.addActionListener(e -> {
            label2.setVisible(false);
            yesButton.setVisible(false);
            noButton.setVisible(false);
            textField.setEditable(true);
        });

        exit2.addActionListener(e -> {
            deleteButton.setVisible(true);
            textField.setVisible(true);
            label1.setVisible(true);
            exit2.setVisible(false);
            exit.setVisible(true);
            textField.setEditable(true);
            re.setVisible(false);
            re2.setVisible(false);
        });


    }
}
