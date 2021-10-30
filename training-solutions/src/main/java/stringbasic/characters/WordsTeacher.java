package stringbasic.characters;

public class WordsTeacher {

    private String word;

    public WordsTeacher(String word) {
        this.word = word;
    }

    public int getWordLength() {
        return word.length();
    }

    public String getWord() {
        return word;
    }
}
