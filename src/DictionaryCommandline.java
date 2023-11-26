import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryCommandline extends DictionaryManagement{




    public String showAllWord() {
        String s = "No\t|\tEnglish\t\t|\tVietnamese\n";
        int no = 1;
        for (int i = 0; i < dic.wordList.size(); i++) {
            s += no + "\t|\t" + dic.wordList.get(i).getWord_target()
                    + "\t\t|\t" + dic.wordList.get(i).getWord_explain() + "\n";
            no++;
        }
        System.out.println(dic.wordList.size());
        return s;
    }

    public void insertFromCommandline() {
        Scanner sc = new Scanner(System.in);
        Word addedW = new Word();
        addedW.setWord_target(sc.next());
        addedW.setWord_explain(sc.nextLine());
        dic.wordList.add(addedW);
    }

    public void dictionaryBasic() {
        insertFromCommandline();
        showAllWord();

    }

    public static void main(String[] args) throws IOException {
        DictionaryCommandline ad = new DictionaryCommandline();
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to My Application!\n" +
                "[0] Exit\n" +
                "[1] Add\n" +
                "[2] Remove\n" +
                "[3] Update\n" +
                "[4] Display\n" +
                "[5] Lookup\n" +
                "[6] Search\n" +
                "[7] Game\n" +
                "[8] Import from file\n" +
                "[9] Export to file");

        String lenh = "";
        boolean run = true;
        while (run) {
            System.out.println("Nhập lệnh:");
            lenh = sc.next();
            if (lenh.equals("0")){
                run = false;
            } else if (lenh.equals("1")){
                System.out.println("Word:");
                String word = sc.next();
                String type = "";
                String pronouce = "";
                System.out.println("Mean:");
                String mean = sc.next();
                if(ad.dictionaryAddWord(word,type,pronouce,mean))
                    System.out.println("This word's already exist!");
                else {
                    System.out.println("Add success!");
                    ad.dictionaryExportToFile("C:\\Users\\User\\IdeaProjects\\project\\src\\cmldictionaries.txt");
                }
            } else if (lenh.equals("2")) {
                System.out.println("Word:");
                String word = sc.next();
                ad.dictionaryRemoveWord(word);
                if(ad.getK() == -1) System.out.println("This word doesn't exist!");
                else{
                    System.out.println("Success!");
                    ad.dictionaryExportToFile("C:\\Users\\User\\IdeaProjects\\project\\src\\cmldictionaries.txt");
                }
            } else if (lenh.equals("3")) {
                System.out.println("Word:");
                String word = sc.next();
                String w = word;
                String type = "";
                String pronouce = "";
                System.out.println("Mean:");
                String mean = sc.next();
                ad.updateWord(w,word,type,pronouce,mean);
                if (ad.getN() == -1) System.out.println("This word doesn't exist!");
                else {
                    System.out.println("Success!");
                    ad.dictionaryExportToFile("C:\\Users\\User\\IdeaProjects\\project\\src\\cmldictionaries.txt");
                }
            } else if (lenh.equals("4")) {
                System.out.println(ad.showAllWord());
            } else if (lenh.equals("5")) {
                System.out.println("Word:");
                String word = sc.next();
                System.out.println("Meaning:\n" + ad.DictionaryLookup(word));
            } else if (lenh.equals("6")) {
                System.out.println("Word");
                String word = sc.next();
                ArrayList<String> SearchedWords = ad.search(word);
                for (String searchedWord : SearchedWords) {
                    System.out.println(searchedWord);
                }
            } else if (lenh.equals("7")) {
                System.out.println("\n" +
                        "0. What _ you doing?\n" +
                        "A. are\n" +
                        "B. do\n" +
                        "C. is\n" +
                        "D. have\n" +
                        "Your choice [A/B/C/D]:");
                String choice = sc.next();
                choice = choice.toUpperCase();
                if(choice.equals("A")) System.out.println("Win");
                else System.out.println("Fail");
                System.out.println("\n" +
                        "1. I have been waiting for you……………\n" +
                        " A. since early morning\n" +
                        " B. since 9 a.m\n" +
                        " C. for two hours\n" +
                        " D. all are correct\n"+
                        "Your choice [A/B/C/D]:");
                choice = sc.next();
                choice = choice.toUpperCase();
                if(choice.equals("D")) System.out.println("Win");
                else System.out.println("Fail");
                System.out.println("\n" +
                        "2. My sister…………for you since yesterday.\n" +
                        " A. is looking\n" +
                        " B. was looking\n" +
                        " C. has been looking\n" +
                        " D. looked\n"+
                        "Your choice [A/B/C/D]:");
                choice = sc.next();
                choice = choice.toUpperCase();
                if(choice.equals("C")) System.out.println("Win");
                else System.out.println("Fail");
                System.out.println("\n" +
                        "3. Jack…………the door.\n" +
                        " A. has just painted\n" +
                        " B. paint\n" +
                        " C. will have painted\n" +
                        " D. painting\n"+
                        "Your choice [A/B/C/D]:");
                choice = sc.next();
                choice = choice.toUpperCase();
                if(choice.equals("A")) System.out.println("Win");
                else System.out.println("Fail");
            } else if (lenh.equals("8")) {
                ad.insertFromFile();
            } else if (lenh.equals("9")) {
                System.out.println("File name:");
                String s = sc.next();
                ad.dictionaryExportToFile(s);
            } else {
                System.out.println("Action not supported");
            }
        }


    }
}