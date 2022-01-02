package controlselection.consonant;

import java.util.Arrays;
import java.util.List;

public class ToConsonant {

    public char toConsonant(char vowel) {
        char consonant;
        List<Character> vowels = Arrays.asList('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U');
        if (vowels.contains(vowel)) {
            consonant = (char) (vowel + 1);
        } else {
            consonant = vowel;
        }
        return consonant;
    }

    public char toConsonantWithSwitch(char vowel) { //Just for fun!
        char consonant;
        switch (vowel) {
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                consonant = (char) (vowel + 1);
                break;
            default:
                consonant = vowel;
        }
        return consonant;
    }
}
