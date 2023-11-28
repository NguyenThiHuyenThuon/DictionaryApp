import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Button7 extends JFrame {
    JTextArea textFieldA = new JTextArea();
    JButton exit;
    JButton Sbutton;
    JTextArea mean = new JTextArea();

    JButton loa;

    private static Image scaleImage(Image image, int w, int h) {
        Image scaled = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return scaled;
    }

    private static String translate(String langFrom, String langTo, String text) throws IOException {
        // INSERT YOU URL HERE
        String urlStr = "https://script.google.com/macros/s/AKfycbxK0fEug_yMQpmLS-h2izDxrjlbS1He0JtktiwUgEcKpc1xVWHYrapCIf5ZwO0J3YzH/exec" +
                "?q=" + URLEncoder.encode(text, "UTF-8") +
                "&target=" + langTo +
                "&source=" + langFrom;
        URL url = new URL(urlStr);
        StringBuilder response = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }
    public Button7() {
        setTitle("DictionaryApp");
        getContentPane().setBackground(new Color(167, 217, 181));
        setBounds(350, 100, 600, 800);
        setLayout(null);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelSearched = new JLabel("Search Bar:");
        labelSearched.setBounds(50, 50, 200, 20);
        labelSearched.setFont(new Font("Segoe UI Black", 2, 20));
        add(labelSearched);

        ImageIcon originalIcon = new ImageIcon
                ("C:\\Users\\User\\IdeaProjects\\project\\src\\Sicon.png");
        Image scaled = scaleImage(originalIcon.getImage(), 20, 20);
        ImageIcon scaledIcon = new ImageIcon(scaled);
        Sbutton = new JButton(scaledIcon);
        Sbutton.setBounds(425, 100, 40, 25);
        add(Sbutton);

        ImageIcon exitIcon = new ImageIcon("C:\\Users\\User\\IdeaProjects\\project\\src\\ex.png");
        Image scal = scaleImage(exitIcon.getImage(), 50, 30);
        ImageIcon scalIcon = new ImageIcon(scal);
        exit = new JButton(scalIcon);
        exit.setBounds(5, 5, 50, 30);
        add(exit);

        mean.setEditable(false);
        mean.setFont(new Font("Segoe UI Black", 2, 15));
        mean.setBounds(50,340,450,300);
        mean.setForeground(Color.BLACK);
        mean.setWrapStyleWord(true);
        mean.setLineWrap(true);
        add(mean);

        textFieldA.setBounds(80, 80, 300, 200);
        textFieldA.setFont(new Font("Segoe UI Black", 2, 15));
        textFieldA.setWrapStyleWord(true);
        textFieldA.setLineWrap(true);
        add(textFieldA);

        JLabel label = new JLabel("Meaning:");
        label.setBounds(50, 290, 120, 40);
        label.setFont(new Font("Segoe UI Black", 2, 22));
        add(label);

        ImageIcon loaIcon = new ImageIcon("C:\\Users\\User\\IdeaProjects\\project\\src\\loa.png");
        Image loam = scaleImage(loaIcon.getImage(), 30, 20);
        ImageIcon loak = new ImageIcon(loam);
        loa = new JButton(loak);
        loa.setBounds(161, 300, 30, 20);
        add(loa);

        JScrollPane pane = new JScrollPane();
        pane.setViewportView(mean);
        pane.setBounds(50,340,450,300);
        add(pane);

        JScrollPane pane1 = new JScrollPane();
        pane1.setViewportView(textFieldA);
        pane1.setBounds(120, 80, 300, 200);
        add(pane1);

        Sbutton.addActionListener(e -> {
            try {
                mean.setText(translate("en","vi", textFieldA.getText()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            loa.addActionListener(ae -> {

                VoiceManager vm = VoiceManager.getInstance();
                Voice voice = vm.getVoice("kevin");

                voice.allocate();

                voice.speak(textFieldA.getText());
            });
        });

        setVisible(false);
    }

}
