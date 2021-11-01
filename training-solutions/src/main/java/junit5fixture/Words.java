package junit5fixture;

import java.util.ArrayList;
import java.util.List;

public class Words {

    List<String> words = new ArrayList<>();

    public void getWordsStartWith(String prefix) {
        List<String> wordsToRemove = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            if (!words.get(i).startsWith(prefix)) {
                wordsToRemove.add(words.get(i));
            }
        }
        words.removeAll(wordsToRemove);
    }

    public void getWordsWithLength(int length) {
        List<String> wordsToRemove = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).length() != length) {
                wordsToRemove.add(words.get(i));
            }
        }
        words.removeAll(wordsToRemove);
    }

    public void addWord(String word) {
        words.add(word);
    }

    public List<String> getWords() {
        return words;
    }
}
