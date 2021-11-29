package methodchain;

public class ModifiedWord {

    public String modify (String word) {
        if (word.length() < 4) {
            throw new IllegalArgumentException("The word must be at least three characters length!");
        }
        char c = word.toUpperCase().charAt(1);
        return word.substring(0, 3).toUpperCase().replace(c, 'x') + 'y';
    }
}
