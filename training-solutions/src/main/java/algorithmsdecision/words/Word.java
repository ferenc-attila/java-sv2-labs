package algorithmsdecision.words;

import java.util.List;

public class Word {

    public boolean containsLongerWord(List<String> words, String wordToCheck) {
        for (String wordInList : words) {
            if (getLengthOfWord(wordInList) > getLengthOfWord(wordToCheck)) {
                return true;
            }
        }
        return false;
    }

    private int getLengthOfWord(String word) {
        return word.length();
    }
}
