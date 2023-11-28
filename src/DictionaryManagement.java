import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Vector;

public class DictionaryManagement extends Dictionary {
    Dictionary dic = new Dictionary();
    int k = -1;
    int n = -1;
    int m = -1;

    int a = -1;
    public int getK() {
        return k;
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public int getA() {
        return a;
    }

    public void insertFromFile() throws FileNotFoundException {
        Scanner sc = new Scanner(new File(
                "C:\\Users\\User\\IdeaProjects\\project\\src\\dictionaries.txt"));
        while (sc.hasNext()) {
            Word tmp = new Word();
            sc.next();
            tmp.word_target = sc.next();
            tmp.word_explain = sc.nextLine();
            dic.wordList.add(tmp);
        }
    }

    public void addSound() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        Scanner sc = new Scanner(new File("C:\\Users\\User\\IdeaProjects\\project\\src\\mp3.txt"));
        int i = 0;
        while (sc.hasNext()) {
            File file = new File("C:\\Users\\User\\IdeaProjects\\project\\src\\mp3\\"+sc.nextLine());
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            dic.wordList.get(i).clip =AudioSystem.getClip();
            dic.wordList.get(i).clip.open(audioInputStream);
            i++;
        }
    }
    public ArrayList<String> change() {

        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < dic.wordList.size(); i++) {
            list.add(dic.wordList.get(i).getWord_target());
        }

        return list;
    }

    public String DictionaryLookup(String word) {
        for (int i = 0; i < dic.wordList.size(); i++) {
            String s = dic.wordList.get(i).getWord_target();
            if(Objects.equals(s, word)) {
                m = i;
                break;
            }
        }
        if(m >= 0 && m<dic.wordList.size())
        return dic.wordList.get(m).getWord_explain();
        else {
            m = -1;
            return "This word doesn't exist!";
        }
    }

    public String DictionaryLookupV(String mean) {
        for (int i = 0; i < dic.wordList.size(); i++) {
            String s = dic.wordList.get(i).getWord_explain();
            if(Objects.equals(s, mean)) {
                a = i;
                break;
            }
        }
        if(a >= 0 && a<dic.wordList.size()) {
            return dic.wordList.get(a).getWord_target();

        }
        else {
            a = -1;
            return "This word doesn't exist!";
        }
    }


    public boolean dictionaryAddWord(String word, String type, String pronounce ,String mean) throws IOException {
        boolean check = false;
        String s = type + "        /" + pronounce + "/        " + mean;
        for(int i = 0; i < dic.wordList.size(); i++) {
            if (Objects.equals(word, dic.wordList.get(i).getWord_target()) ) {
                    check = true;
            }
        }

        if(!check) {
            Word newWord = new Word();
            newWord.setWord_target(word);
            newWord.setWord_explain(s);
            dic.wordList.add(newWord);

        }

        return check;
    }

    public void dictionaryRemoveWord(String word) throws IOException {
        for (int i = 0; i < dic.wordList.size(); i++) {
            String s = dic.wordList.get(i).getWord_target();
            if(Objects.equals(s, word)) {
                k = i;
                break;
            }
        }
        System.out.println(k);
        if(k >= 0 && k<dic.wordList.size()) {
            dic.wordList.remove(k);
            dictionaryExportToFile("C:\\Users\\User\\IdeaProjects\\project\\src\\dictionaries.txt");
        }
        else k = -1;
    }

    public void updateWord(String w, String word, String type, String pronounce , String mean) {

        String s = null;
        if(!type.isEmpty() && !pronounce.isEmpty()) {
            s = type + "        /" + pronounce + "/        " + mean;
        } else if(type.isEmpty() && !pronounce.isEmpty()) {
            s = "/" + pronounce + "/        " + mean;
        } else if(pronounce.isEmpty() && !type.isEmpty()) {
            s = type + "        " + mean;
        } else if (pronounce.isEmpty() && type.isEmpty()) {
            s = mean;
        }

        for (int i = 0; i < dic.wordList.size(); i++) {
            if(Objects.equals(w, dic.wordList.get(i).getWord_target())) {
                n = i;
            }
        }

        if (n >= 0 && n < dic.wordList.size()) {
            if (word.isEmpty() && !s.isEmpty()) {
                dic.wordList.get(n).setWord_explain(
                        dic.wordList.get(n).getWord_explain() + "/   " + s
                );
            } else if (!word.isEmpty() && s.isEmpty()) {
                dic.wordList.get(n).setWord_target(word);
            } else if (!word.isEmpty() && !s.isEmpty()) {
                dic.wordList.get(n).setWord_target(word);
                dic.wordList.get(n).setWord_explain(
                        dic.wordList.get(n).getWord_explain() + "/   " + s
                );
            }
        } else n = -1;
    }
    public void dictionaryExportToFile(String s) throws IOException {
        File file = new File(s);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (file.createNewFile()) {
            System.out.print("");
        } else {
            System.out.print("");
        }
        FileWriter writer = new FileWriter(file);

        for (int i = 0; i < dic.wordList.size(); i++) {
            String k = i+1 + "  " + dic.wordList.get(i).getWord_target()
                    + "   " + dic.wordList.get(i).getWord_explain() + "\n";
            writer.write(k);
        }
        writer.close();
    }

    public ArrayList<String> search(String word) {

        ArrayList<String> SearchedWords = new ArrayList<>();
        for (int i = 0; i < dic.wordList.size(); i++) {
            if(dic.wordList.get(i).getWord_target().contains(word)) {
                SearchedWords.add(dic.wordList.get(i).getWord_target());
            }
        }
        return SearchedWords;
    }
}
