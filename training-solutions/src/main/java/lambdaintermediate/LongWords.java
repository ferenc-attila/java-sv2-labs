package lambdaintermediate;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class LongWords {

    private List<String> words;

    public LongWords(List<String> words) {
        this.words = words;
    }

    public long getNumberOfWordsStartWith(String keyWord) {
        return words.stream()
                .filter(s -> s.startsWith(keyWord))
                .count();
    }

    public List<String> getLongerWords(int number) {
        return words.stream()
                .filter(s -> s.length() > number)
                .toList();
    }

    public Optional<String> getShortestWordContainingGivenCharacter(char character) {
        return words.stream()
                .filter(s -> s.indexOf(character) >= 0)
                .min(Comparator.comparing(String::length));
    }
}
