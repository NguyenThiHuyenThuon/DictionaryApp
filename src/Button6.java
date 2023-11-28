import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;


public class Button6 extends JFrame {

    JTextField textFieldA = new JTextField();
    JButton exit;
    JButton Sbutton;
    JTextArea mean = new JTextArea();

    JButton loa;
    private static Image scaleImage(Image image, int w, int h) {
        Image scaled = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return scaled;
    }

    public Button6() {
        setTitle("DictionaryApp");
        getContentPane().setBackground(new Color(167, 217, 181));
        setBounds(350, 100, 600, 800);
        setLayout(null);

        JLabel labelSearched = new JLabel("Search Bar:");
        labelSearched.setBounds(50, 50, 200, 20);
        labelSearched.setFont(new Font("Segoe UI Black", 2, 20));
        add(labelSearched);


        ImageIcon originalIcon = new ImageIcon
                ("C:\\Users\\User\\IdeaProjects\\project\\src\\Sicon.png");
        Image scaled = scaleImage(originalIcon.getImage(), 20, 20);
        ImageIcon scaledIcon = new ImageIcon(scaled);
        Sbutton = new JButton(scaledIcon);
        Sbutton.setBounds(421, 79, 40, 25);
        add(Sbutton);

        ImageIcon exitIcon = new ImageIcon("C:\\Users\\User\\IdeaProjects\\project\\src\\ex.png");
        Image scal = scaleImage(exitIcon.getImage(), 50, 30);
        ImageIcon scalIcon = new ImageIcon(scal);
        exit = new JButton(scalIcon);
        exit.setBounds(5, 5, 50, 30);
        add(exit);

        mean.setEditable(false);
        mean.setFont(new Font("Segoe UI Black", 2, 15));
        mean.setBounds(120,240,345,200);
        mean.setForeground(Color.BLACK);
        mean.setWrapStyleWord(true);
        mean.setLineWrap(true);
        add(mean);


        JLabel label = new JLabel("Meaning:");
        label.setBounds(50, 170, 120, 40);
        label.setFont(new Font("Segoe UI Black", 2, 22));
        add(label);

        ImageIcon loaIcon = new ImageIcon("C:\\Users\\User\\IdeaProjects\\project\\src\\loa.png");
        Image loam = scaleImage(loaIcon.getImage(), 30, 20);
        ImageIcon loak = new ImageIcon(loam);
        loa = new JButton(loak);
        loa.setBounds(161, 181, 30, 20);
        add(loa);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private final JComboBox combo = new JComboBox();
    private boolean hide_flag = false;
    Vector<String> SearchedWords = new Vector<>();
    public void searchBar(ArrayList<String> list){

       combo.setEditable(true);
       textFieldA = (JTextField) combo.getEditor().getEditorComponent();
       textFieldA.addKeyListener(new KeyAdapter() {
           @Override
           public void keyTyped(KeyEvent e) {
               EventQueue.invokeLater(new Runnable(){
                   public void run() {
                       String text = textFieldA.getText();
                       if (text.length() == 0) {
                           combo.hidePopup();
                           setModel(new DefaultComboBoxModel(SearchedWords), "");
                       }else{
                           DefaultComboBoxModel m = getSuggestedModel(SearchedWords, text);
                           if(m.getSize()==0 || hide_flag) {
                               combo.hidePopup();
                               hide_flag = false;
                           }else{
                               setModel(m, text);
                               combo.showPopup();
                           }
                       }
                   }
               });
               for(int i=1;i<list.size();i++){
                   SearchedWords.addElement(list.get(i));
               }
           }

           public void keyPressed(KeyEvent e) {
               String text = textFieldA.getText();
               int code = e.getKeyCode();
               if(code==KeyEvent.VK_ENTER) {
                   if(!SearchedWords.contains(text)) {
                       SearchedWords.addElement(text);
                       Collections.sort(SearchedWords);
                       setModel(getSuggestedModel(SearchedWords, text), text);
                   }
                   hide_flag = true;
               }else if(code==KeyEvent.VK_ESCAPE) {
                   hide_flag = true;
               }else if(code==KeyEvent.VK_RIGHT) {
                   for(int i=0;i<SearchedWords.size();i++) {
                       String str = SearchedWords.elementAt(i);
                       if(str.startsWith(text)) {
                           combo.setSelectedIndex(-1);
                           textFieldA.setText(str);
                           return;
                       }
                   }
               }
           }
       });
        setModel(new DefaultComboBoxModel(SearchedWords), "");
        JPanel p = new JPanel(new BorderLayout());
        p.add(combo, BorderLayout.NORTH);
        add(p);
        p.setBounds(120,80,300,30);
        p.setBackground(new Color(167, 217, 181));
    }
    private void setModel(DefaultComboBoxModel mdl, String str) {
        combo.setModel(mdl);
        combo.setSelectedIndex(-1);
        textFieldA.setText(str);
    }
    private static DefaultComboBoxModel getSuggestedModel(java.util.List<String> list, String text) {
        DefaultComboBoxModel m = new DefaultComboBoxModel();
        for(String s: list) {
            if(s.startsWith(text)) m.addElement(s);
        }
        return m;
    }
}
