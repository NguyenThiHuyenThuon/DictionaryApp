import javax.swing.*;
import java.awt.*;

public class Button9 extends JFrame {
    JLabel re1;
    JLabel re2;
    JTextField fileName = new JTextField();
    JButton exit;
    JButton saveButton;

    String s = "C:\\Users\\User\\IdeaProjects\\project\\src\\";
    private static Image scaleImage(Image image, int w, int h) {
        Image scaled = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return scaled;
    }
    public Button9() {
        setTitle("DictionaryApp");
        getContentPane().setBackground(new Color(161, 161, 161));
        setBounds(333+600, 100+500,403, 300);
        setLayout(null);

        re1 = new JLabel("File has saved in:");
        re1.setFont(new Font("Arial",1,20));
        re1.setBounds(110,100,300,20);
        add(re1);
        re1.setVisible(false);

        re2 = new JLabel("C:\\Users\\User\\IdeaProjects\\project\\src\\");
        re2.setFont(new Font("Arial",1,15));
        re2.setBounds(30,130,400,20);
        add(re2);
        re2.setVisible(false);



        JLabel label1 = new JLabel("Please name the file you want to save:");
        label1.setFont(new Font("Arial",1,20));
        label1.setBounds(10,100,380,30);
        add(label1);
        label1.setVisible(true);

        fileName.setFont(new Font("Arial",1,17));
        fileName.setBounds(130,150,120,30);
        add(fileName);
        fileName.setVisible(true);

        ImageIcon exitIcon = new ImageIcon("C:\\Users\\User\\IdeaProjects\\project\\src\\exit.png");
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

        ImageIcon saveIcon = new ImageIcon("C:\\Users\\User\\IdeaProjects\\project\\src\\saveIcon.png");
        Image scale = scaleImage(saveIcon.getImage(), 45,25);
        ImageIcon scaleIcon = new ImageIcon(scale);
        saveButton = new JButton(scaleIcon);
        saveButton.setBounds(327,5,50,30);
        add(saveButton);

        saveButton.addActionListener(e -> {
            re2.setText(re2.getText() + fileName.getText()+".txt");
            re2.setVisible(true);
            re1.setVisible(true);
            label1.setVisible(false);
            fileName.setVisible(false);
            saveButton.setVisible(false);
            exit.setVisible(false);
            exit2.setVisible(true);
        });

        exit2.addActionListener(e -> {
            re1.setVisible(false);
            re2.setVisible(false);
            fileName.setText("");
            label1.setVisible(true);
            fileName.setVisible(true);
            saveButton.setVisible(true);
            exit.setVisible(true);
            exit2.setVisible(false);
        });

    }
}
