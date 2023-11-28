import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class game2 extends JFrame {
    ArrayList<String> quest = new ArrayList<>();
    ArrayList<String> ans = new ArrayList<>();

    ArrayList<Integer> randomInt = new ArrayList<>();
    ArrayList<JTextArea> q = new ArrayList<JTextArea>();
    ArrayList<String> ranans = new ArrayList<>();
    JLabel Answer = new JLabel("Answer:");


    JButton A = new JButton("A");
    JButton B = new JButton("B");
    JButton C = new JButton("C");
    JButton D = new JButton("D");
    JLabel vI;
    JButton nextIcon;
    JLabel xI;
    JButton exit;
    JLabel scoreLabel = new JLabel("Score: 0/5");

    AtomicInteger score = new AtomicInteger();
    AtomicInteger l = new AtomicInteger();

    fr2 fr2 = new fr2();
    private static Image scaleImage(Image image, int w, int h) {
        Image scaled = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return scaled;
    }

    public game2() throws FileNotFoundException {

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

        ImageIcon vIcon = new ImageIcon("C:\\Users\\User\\IdeaProjects\\project\\src\\Vicon.png");
        Image sca = scaleImage(vIcon.getImage(), 50, 50);
        ImageIcon scalIco = new ImageIcon(sca);
        vI = new JLabel(scalIco);
        vI.setForeground(new Color(0,0,0));
        vI.setBounds(250,450,100,50);
        vI.setVisible(false);
        add(vI);


        ImageIcon next = new ImageIcon("C:\\Users\\User\\IdeaProjects\\project\\src\\next.png");
        Image scalp = scaleImage(next.getImage(), 100, 50);
        ImageIcon scalpIcon = new ImageIcon(scalp);
        nextIcon = new JButton(scalpIcon);
        nextIcon.setForeground(new Color(0,0,0));
        nextIcon.setBounds(240,650,100,50);
        add(nextIcon);
        nextIcon.setVisible(false);

        ImageIcon xIcon = new ImageIcon("C:\\Users\\User\\IdeaProjects\\project\\src\\xIcon.png");
        Image scale = scaleImage(xIcon.getImage(), 50, 50);
        ImageIcon scaleIcon = new ImageIcon(scale);
        xI = new JLabel(scaleIcon);
        xI.setForeground(new Color(0,0,0));
        xI.setBounds(250,450,100,50);
        xI.setVisible(false);
        add(xI);

        A.setBounds(50,400,150,40);
        A.setFont(new Font("Cooper", 1, 16));
        B.setBounds(400,400,150,40);
        B.setFont(new Font("Cooper", 1, 16));
        C.setBounds(50,500,150,40);
        C.setFont(new Font("Cooper", 1, 16));
        D.setBounds(400,500,150,40);
        D.setFont(new Font("Cooper", 1, 16));
        add(A);
        add(B);
        add(C);
        add(D);

        scoreLabel.setBounds(400,5,200,30);
        scoreLabel.setFont(new Font("Arial",1,30));
        add(scoreLabel);

        Answer.setBounds(50,380,100,15);
        add(Answer);
        Scanner sc = new Scanner(new File("C:\\Users\\User\\IdeaProjects\\project\\src\\test1.txt"));
        int dem = 0;
        String s = "";
        while (sc.hasNext()){
            s += sc.nextLine()+"\n";
            dem++;
            if (dem == 5) {
                quest.add(s);
                String answ = sc.nextLine();
                ans.add(answ);
                s="";
                dem = 0;
            }
        }

        for (int i = 0; i < 5; i++) {
            double randomDouble = Math.random();
            randomDouble = randomDouble * (quest.size() - 1) + 0;
            int random = (int) randomDouble;
            randomInt.add(random);
        }
        for (int i = 0; i < 5; i++) {
            JTextArea tmp = new JTextArea();
            String k = quest.get(randomInt.get(i));
            tmp.setText(k);
            tmp.setBounds(30,50, 500,250);
            tmp.setFont(new Font("Arial",1,30));
            tmp.setWrapStyleWord(true);
            tmp.setLineWrap(true);
            q.add(tmp);
        }
        for (int i = 0; i < 5; i++) {
            add(q.get(i));
            q.get(i).setVisible(false);
            ranans.add(ans.get(randomInt.get(i)));
        }


            q.get(l.get()).setVisible(true);
            A.addActionListener(e -> {
                if (ranans.get(l.get()).equals("A")) {
                    vI.setVisible(true);
                    score.getAndIncrement();
                    scoreLabel.setText("Score: " + score + "/5");
                }
                else xI.setVisible(true);
                nextIcon.setVisible(true);
                A.setEnabled(false);
                B.setEnabled(false);
                C.setEnabled(false);
                D.setEnabled(false);
            });
            B.addActionListener(e -> {
                if (ranans.get(l.get()).equals("B")) {
                    vI.setVisible(true);
                    score.getAndIncrement();
                    scoreLabel.setText("Score: " + score + "/5");
                }
                else xI.setVisible(true);
                nextIcon.setVisible(true);
                A.setEnabled(false);
                B.setEnabled(false);
                C.setEnabled(false);
                D.setEnabled(false);
            });
            C.addActionListener(e -> {
                if (ranans.get(l.get()).equals("C")) {
                    vI.setVisible(true);
                    score.getAndIncrement();
                    scoreLabel.setText("Score: " + score + "/5");
                }
                else xI.setVisible(true);
                nextIcon.setVisible(true);
                A.setEnabled(false);
                B.setEnabled(false);
                C.setEnabled(false);
                D.setEnabled(false);
            });
            D.addActionListener(e -> {
                if (ranans.get(l.get()).equals("D")) {
                    vI.setVisible(true);
                    score.getAndIncrement();
                    scoreLabel.setText("Score: " + score + "/5");
                }
                else xI.setVisible(true);
                nextIcon.setVisible(true);
                A.setEnabled(false);
                B.setEnabled(false);
                C.setEnabled(false);
                D.setEnabled(false);
            });

            nextIcon.addActionListener(e -> {
                A.setEnabled(true);
                B.setEnabled(true);
                C.setEnabled(true);
                D.setEnabled(true);
                nextIcon.setVisible(false);
                xI.setVisible(false);
                vI.setVisible(false);
                if (l.get() < 4) {
                    l.getAndIncrement();
                    q.get(l.get()).setVisible(true);
                    l.getAndDecrement();
                    q.get(l.get()).setVisible(false);
                    l.getAndIncrement();
                } else {
                    A.setVisible(false);
                    B.setVisible(false);
                    C.setVisible(false);
                    D.setVisible(false);
                    for (int i = 0; i< q.size(); i++) {
                        q.get(i).setVisible(false);
                    }
                    vI.setVisible(false);
                    xI.setVisible(false);
                    scoreLabel.setVisible(false);
                    Answer.setVisible(false);
                    fr2.setVisible(true);
                    fr2.scoreLabel.setText("Score:\n" + score + "/5");
                    fr2.scoreLabel.setVisible(true);
                    l.set(0);
                    score.set(0);
                }
            });



        setVisible(false);
    }

}


class fr2 extends f {
    JLabel scoreLabel = new JLabel();

    JButton playAgain;

    private static Image scaleImage(Image image, int w, int h) {
        Image scaled = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return scaled;
    }
    public fr2() {

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
        playAgain.setBackground(new Color(245, 154, 208));
        add(playAgain);

        setVisible(false);
    }
}

