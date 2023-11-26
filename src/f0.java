import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class f0 extends f {
    JButton start;

    private static Image scaleImage(Image image, int w, int h) {
        Image scaled = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return scaled;
    }

    public f0() {
        exit.setVisible(false);

        JLabel label = new JLabel("Nhìn Nghĩa Đoán Từ");
        label.setFont(new Font("Arial",1,40));
        label.setBounds(100, 200, 400,50);
        add(label);

        ImageIcon playIcon = new ImageIcon("C:\\Users\\User\\IdeaProjects\\project\\src\\start.png");
        Image scale = scaleImage(playIcon.getImage(), 200, 200);
        ImageIcon scalIcon = new ImageIcon(scale);
        start = new JButton(scalIcon);
        start.setBounds(150, 250, 400, 400);
        start.setBorder(new EmptyBorder(150, 250, 300, 400));
        start.setBackground(new Color(167, 217, 181));
        add(start);

    }

}
