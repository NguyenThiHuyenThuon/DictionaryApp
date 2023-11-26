import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class DictionaryApplication {
    /** hiển thị giao diện*/
    static DictionaryCommandline ad = new DictionaryCommandline();
    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {

        ad.insertFromFile();
        ad.addSound();
        Main menu = new Main();
        Button2 button2 = new Button2();
        Button3 button3 = new Button3();
        Button4 button4 = new Button4();
        Button5 button5 = new Button5();
        Button6 button6 = new Button6();
        Button9 button9 = new Button9();
        menu.setVisible(true);

        /**1*/
        menu.button1.addActionListener(e->{
            menu.dispatchEvent(new WindowEvent(menu, WindowEvent.WINDOW_CLOSING));
        });

        /**2*/
        menu.button2.addActionListener(e -> {
            menu.setVisible(false);
            button2.setVisible(true);
            button9.setVisible(false);
            button2.addButton.addActionListener(e1 -> {
                if(button2.word.getText().isEmpty() || button2.mean.getText().isEmpty()) {
                    System.out.println(button2.word.getText());
                    button2.re.setVisible(true);
                } else {
                    try {
                        if(ad.dictionaryAddWord(
                                button2.word.getText(), button2.type.getText(),
                                button2.pronouce.getText(), button2.mean.getText())) {
                            button2.re1.setVisible(true);
                        } else {
                            button2.re2.setVisible(true);
                            ad.dictionaryExportToFile("C:\\Users\\User\\IdeaProjects\\project\\src\\dictionaries.txt");
                        }
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
        });

        button2.exit.addActionListener(e -> {
            menu.setVisible(true);
            button2.setVisible(false);
        });

        /**3*/
        menu.button3.addActionListener(e -> {
            button3.setVisible(true);
            menu.setVisible(false);
        });

        button3.exit.addActionListener(e -> {
            menu.setVisible(true);
            button9.setVisible(false);
            button3.setVisible(false);
        });

        button3.yesButton.addActionListener(e -> {
            try {
                ad.dictionaryRemoveWord(button3.textField.getText());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            if(ad.getK()!=-1) button3.re2.setVisible(true);
            else button3.re.setVisible(true);
        });

        /**4*/
        menu.button4.addActionListener(e -> {
            menu.setVisible(false);
            button9.setVisible(false);
            button4.frame1.setVisible(true);
        });

        button4.frame1.exit.addActionListener(e->{
            button4.frame1.w.setText("");
            menu.setVisible(true);
            button4.frame1.setVisible(false);
        });

        button4.frame2.exit.addActionListener(e -> {
            button4.frame1.setVisible(true);
            button4.frame2.setVisible(false);
        });


        button4.frame1.addButton.addActionListener(e -> {

            ad.updateWord(button4.frame1.w.getText(),button4.frame2.word.getText(),
                    button4.frame2.type.getText(),button4.frame2.pronouce.getText(),
                    button4.frame2.mean.getText());
            if(button4.frame1.w.getText().isEmpty()||ad.getN()== -1) {
                button4.frame3.setVisible(true);
                button4.frame3.re.setVisible(true);
                button4.frame1.setVisible(false);
            } else {
                button4.frame2.setVisible(true);
                button4.frame2.addButton.addActionListener(e1 -> {
                    button4.frame2.setVisible(false);
                    ad.updateWord(button4.frame1.w.getText(),button4.frame2.word.getText(),
                            button4.frame2.type.getText(),button4.frame2.pronouce.getText(),
                            button4.frame2.mean.getText());
                    if (button4.frame2.word.getText().isEmpty()&&button4.frame2.type.getText().isEmpty()
                    &&button4.frame2.pronouce.getText().isEmpty()&&button4.frame2.mean.getText().isEmpty()) {
                        button4.frame3.setVisible(true);
                        button4.frame3.re.setVisible(true);
                    } else {
                        try {
                            ad.dictionaryExportToFile("C:\\Users\\User\\IdeaProjects\\project\\src\\dictionaries.txt");
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        button4.frame3.setVisible(true);
                        button4.frame3.re2.setVisible(true);
                    }
                });
            }
            button4.frame1.w.setText("");
        });


        /**5*/

        ad.dictionaryExportToFile("C:\\Users\\User\\IdeaProjects\\project\\src\\dictionaries.txt");
        menu.button5.addActionListener(e->{
            menu.setVisible(false);
            button9.setVisible(false);
            button5.setVisible(true);
            button5.txtMain.setText(ad.showAllWord());
        });
        button5.exit.addActionListener(e->{
            menu.setVisible(true);
            button5.setVisible(false);
        });

        /**6*/
        ad.dictionaryExportToFile("C:\\Users\\User\\IdeaProjects\\project\\src\\dictionaries.txt");
        menu.button6.addActionListener(e->{
            menu.setVisible(false);
            button9.setVisible(false);
            button6.setVisible(true);
        });
        button6.exit.addActionListener(e -> {
            button6.mean.setText("");
            button6.textFieldA.setText("");
            menu.setVisible(true);
            button6.setVisible(false);
            button9.setVisible(false);
        });
        button6.searchBar(ad.change());
        button6.Sbutton.addActionListener(e -> {
            String s = ad.DictionaryLookup(button6.textFieldA.getText());
            button6.mean.setText(s);
            button6.loa.addActionListener(e1 -> {
                ad.dic.wordList.get(ad.getM()).clip.start();
            });
        });
        /**8*/

        menu.button8.addActionListener(e -> {
            f0 f0 = new f0();
            f0.setVisible(true);
            menu.setVisible(false);
            f0.start.addActionListener(e1 -> {
                f0.setVisible(false);
                Button8 button8 = new Button8();

                button8.f1.setVisible(true);
                menu.setVisible(false);
                button8.setVisible(true);
                button9.setVisible(false);

                System.out.println(ad.dic.wordList.size());
                button8.f1.ran(ad.dic.wordList);
                AtomicInteger score = new AtomicInteger();

                for (int i = 0; i < 5; i++) {
                    JLabel tmp = new JLabel(
                            ad.dic.wordList.get(button8.f1.randomInt.get(i)).getWord_explain());
                    button8.f1.vietnamese.add(tmp);

                }

                for (int i = 0; i < 5; i++) {
                    button8.f1.vietnamese.get(i).setBounds(50,100,500,100);
                    button8.f1.vietnamese.get(i).setForeground(new Color(0, 0, 0));
                    button8.f1.vietnamese.get(i).setBackground(Color.WHITE);
                    button8.f1.vietnamese.get(i).setVisible(false);
                    button8.f1.setFont(new Font("Segoe UI Black", 2, 20));
                    button8.f1.add(button8.f1.vietnamese.get(i));
                }
                button8.f1.vietnamese.get(0).setVisible(true);
                AtomicInteger l = new AtomicInteger();
                button8.f1.enterButton.addActionListener(e2 -> {
                    String s = ad.DictionaryLookupV(button8.f1.vietnamese.get(l.get()).getText());
                    if( Objects.equals(button8.f1.english.getText(),s)) {
                        button8.vI.setVisible(true);
                        button8.nextIcon.setVisible(true);
                        button8.xI.setVisible(false);
                        score.getAndIncrement();
                        button8.f1.scoreLabel.setText("Score: " + score + "/5");
                        button8.f1.enterButton.setEnabled(false);
                    } else {
                        button8.xI.setVisible(true);
                        button8.nextIcon.setVisible(true);
                        button8.vI.setVisible(false);
                    }
                    System.out.println(Objects.equals(button8.f1.english.getText(),s));
                    button8.f1.english.setEditable(false);

                });

                button8.nextIcon.addActionListener(e2 -> {
                    button8.f1.english.setText("");
                    button8.f1.english.setEditable(true);
                    button8.f1.enterButton.setEnabled(true);
                    button8.xI.setVisible(false);
                    button8.vI.setVisible(false);
                    if(l.get()<4) {
                        l.getAndIncrement();
                        button8.f1.vietnamese.get(l.get()).setVisible(true);
                        System.out.println(l.get());
                        l.getAndDecrement();
                        button8.f1.vietnamese.get(l.get()).setVisible(false);
                        System.out.println(l.get());
                        button8.nextIcon.setVisible(false);
                        l.getAndIncrement();
                        System.out.println(l.get());
                    } else {
                        button8.f1.setVisible(false);
                        button8.f2.scoreLabel.setText("Score:\n" + score + "/5");
                        button8.f2.scoreLabel.setFont(new Font("Arial",1,25));
                        button8.f2.scoreLabel.setVisible(true);
                        button8.f2.setVisible(true);
                        button8.setVisible(true);
                    }
                });

                button8.f1.exit.addActionListener(e2 -> {
                    button8.f1.setVisible(false);
                    menu.setVisible(true);
                    button8.setVisible(false);
                    button9.setVisible(false);
                });

                button8.f2.exit.addActionListener(e2->{
                    button8.setVisible(false);
                    menu.setVisible(true);
                    button8.f2.setVisible(false);
                    button8.f1.setVisible(false);
                });

                button8.f2.playAgain.addActionListener(e2 -> {
                    button8.f2.setVisible(false);
                    f0.setVisible(true);
                    menu.setVisible(false);
                });
            });

        });


        /**9*/
        menu.button9.addActionListener(e -> {
            button9.setVisible(true);
        });
        button9.exit.addActionListener(e -> {
            button9.setVisible(false);

        });
        button9.saveButton.addActionListener(e -> {
            button9.s+=button9.fileName.getText()+".txt";
            try {
                ad.dictionaryExportToFile(button9.s);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });


    }
}
