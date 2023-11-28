
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class Button8 extends JFrame {

    private static Image scaleImage(Image image, int w, int h) {
        Image scaled = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return scaled;
    }
    f1 f1 = new f1();
    JLabel vI;
    JButton nextIcon;
    JLabel xI;

    f2 f2 = new f2();


        public Button8() {
            f1.setVisible(false);
            f2.setVisible(false);
            ImageIcon vIcon = new ImageIcon("C:\\Users\\User\\IdeaProjects\\project\\src\\Vicon.png");
            Image scal = scaleImage(vIcon.getImage(), 50, 50);
            ImageIcon scalIcon = new ImageIcon(scal);
            vI = new JLabel(scalIcon);
            vI.setForeground(new Color(0,0,0));
            vI.setBounds(150,200,300,150);
            f1.add(vI);
            vI.setVisible(false);


            ImageIcon next = new ImageIcon("C:\\Users\\User\\IdeaProjects\\project\\src\\next.png");
            Image scalp = scaleImage(next.getImage(), 70, 30);
            ImageIcon scalpIcon = new ImageIcon(scalp);
            nextIcon = new JButton(scalpIcon);
            nextIcon.setForeground(new Color(0,0,0));
            nextIcon.setBounds(250,500,70,30);
            f1.add(nextIcon);
            nextIcon.setVisible(false);

            ImageIcon xIcon = new ImageIcon("C:\\Users\\User\\IdeaProjects\\project\\src\\xIcon.png");
            Image scale = scaleImage(xIcon.getImage(), 50, 50);
            ImageIcon scaleIcon = new ImageIcon(scale);
            xI = new JLabel(scaleIcon);
            xI.setForeground(new Color(0,0,0));
            xI.setBounds(150,200,300,150);
            f1.add(xI);
            xI.setVisible(false);

            setVisible(false);
        }


}

class f extends JFrame {
    JButton exit;

    private static Image scaleImage(Image image, int w, int h) {
        Image scaled = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return scaled;
    }
    public f() {

        setTitle("DictionaryApp");
        getContentPane().setBackground(new Color(245, 154, 208));
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

        setVisible(false);
    }
}

class f1 extends f{
    ArrayList<Integer> randomInt = new ArrayList<>();
    ArrayList<JLabel> vietnamese = new ArrayList<JLabel>();
    JTextField english = new JTextField();

    JLabel scoreLabel = new JLabel("Score: 0/5");
    JButton enterButton = new JButton("Enter");
    public void ran(ArrayList<Word> list) {

        for(int i = 0; i < 5; i++) {
            double randomDouble = Math.random();
            randomDouble = randomDouble * (list.size() - 1)  + 0;
            int random = (int) randomDouble;
            randomInt.add(random);
        }



    }

    public f1() {
        english.setBounds(120,400,300,30);
        english.setFont(new Font("Segoe UI Black", 2, 15));
        add(english);

        enterButton.setBounds(420,400,100,30);
        add(enterButton);

        scoreLabel.setBounds(400,5,200,30);
        scoreLabel.setFont(new Font("Arial",1,30));
        add(scoreLabel);

        setVisible(false);
    }


}
class f2 extends f {
    JLabel scoreLabel = new JLabel();

    JButton playAgain;

    private static Image scaleImage(Image image, int w, int h) {
        Image scaled = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return scaled;
    }
    public f2() {

        scoreLabel.setBounds(200,250,400,40);
        scoreLabel.setFont(new Font("Arial",1,40));
        scoreLabel.setVisible(false);
        add(scoreLabel);

        ImageIcon playIcon = new ImageIcon("C:\\Users\\User\\IdeaProjects\\project\\src\\playAgainIcon.png");
        Image scale = scaleImage(playIcon.getImage(), 100, 100);
        ImageIcon scalIcon = new ImageIcon(scale);
        playAgain = new JButton(scalIcon);
        playAgain.setBounds(130,300,400,400);
        playAgain.setBorder(new EmptyBorder(130,300,300, 400));
        playAgain.setBackground(new Color(180, 102, 185));
        add(playAgain);
        setVisible(false);
    }
}