import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class Button5 extends JFrame {

    JButton exit;
    JTextArea txtMain = new JTextArea();
    private static Image scaleImage(Image image, int w, int h) {
        Image scaled = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return scaled;
    }
    public Button5() {


        setBounds(350, 100,600, 800);
        setTitle("DictionaryApp");
        txtMain.setBackground(new Color(190, 135, 174));
        setLayout(null);

        ImageIcon exitIcon = new ImageIcon("C:\\Users\\User\\IdeaProjects\\project\\src\\ex.png");
        Image scaled = scaleImage(exitIcon.getImage(), 100, 50);
        ImageIcon scaledIcon = new ImageIcon(scaled);
        exit = new JButton(scaledIcon);
        exit.setBounds(50,50,100,50);
        setLayout(new BorderLayout());

        txtMain.setFont(new Font("Arial",1,16));
        txtMain.setEditable(false);
        String text = txtMain.getText();
        txtMain.setCaretPosition(text!=null? text.length() : 0);
        JScrollPane pane = new JScrollPane();
        pane.setViewportView(txtMain);
        add(exit, BorderLayout.SOUTH);
        add(pane, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
