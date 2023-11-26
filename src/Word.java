import javax.sound.sampled.Clip;

public class Word {
    String word_target;
    String word_explain;
    Clip clip;

    public Word(String wordTarget, String wordExplain) {
        this.word_explain = wordExplain;
        this.word_target = wordTarget;
    }

    public Word() {

    }


    public String getWord_explain() {
        return word_explain;
    }

    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }

    public String getWord_target() {
        return word_target;
    }

    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }

    public void setClip(Clip clip) {
        this.clip = clip;
    }

    public Clip getClip() {
        return clip;
    }
}

