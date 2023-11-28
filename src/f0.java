import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class f0 extends f{
    JButton start;

    private static Image scaleImage(Image image, int w, int h) {
        Image scaled = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return scaled;
    }
    public f0() {
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
