import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.FileNotFoundException;

public class gameFr extends f {

    fr0 fr0 = new fr0();


    fr1 fr1 = new fr1();
    fr2 fr2 = new fr2();

    public gameFr() throws FileNotFoundException {
    }
}

class fr0 extends f{
    JLabel start;
    JButton game1 = new JButton("Game1");
    JButton game2 = new JButton("Game2");
    private static Image scaleImage(Image image, int w, int h) {
        Image scaled = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return scaled;
    }
    public fr0() {
        ImageIcon playIcon = new ImageIcon("C:\\Users\\User\\IdeaProjects\\project\\src\\mini.png");
        Image scale = scaleImage(playIcon.getImage(), 400, 100);
        ImageIcon scalIcon = new ImageIcon(scale);
        start = new JLabel(scalIcon);
        start.setBounds(100, 200, 400,100);
        add(start);

        game1.setBounds(200,350,200,40);
        add(game1);
        game2.setBounds(200,420,200,40);
        add(game2);
    }

}
class fr1 extends f {
    JButton start;

    private static Image scaleImage(Image image, int w, int h) {
        Image scaled = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return scaled;
    }
    public fr1() {
        exit.setVisible(false);

        JLabel label = new JLabel("Điền Vào Chỗ Trống");
        label.setFont(new Font("Arial",1,40));
        label.setBounds(100, 200, 400,50);
        add(label);

        ImageIcon playIcon = new ImageIcon("C:\\Users\\User\\IdeaProjects\\project\\src\\start.png");
        Image scale = scaleImage(playIcon.getImage(), 200, 200);
        ImageIcon scalIcon = new ImageIcon(scale);
        start = new JButton(scalIcon);
        start.setBounds(155, 270, 400, 400);
        start.setBorder(new EmptyBorder(150, 270, 300, 400));
        start.setBackground(new Color(245, 154, 208));
        add(start);

        setVisible(false);
    }
}
