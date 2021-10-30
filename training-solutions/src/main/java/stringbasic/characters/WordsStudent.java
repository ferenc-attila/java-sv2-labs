package stringbasic.characters;

import java.util.ArrayList;
import java.util.List;

public class WordsStudent {

    List<String> enteredCharacters = new ArrayList<>();

    public void addCharacter(String character) {
        enteredCharacters.add(character);
    }

    public String getEnteredWord() {
        String enteredWord = "";
        for (int i = 0; i < enteredCharacters.size(); i++) {
            enteredWord = enteredWord + enteredCharacters.get(i);
        }
        return enteredWord;
    }

    public List<String> getCharacters() {
        return enteredCharacters;
    }
}
