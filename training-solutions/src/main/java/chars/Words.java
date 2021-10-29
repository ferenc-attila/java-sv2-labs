package chars;

public class Words {

    public String pushWord(String word) {
        char[] letters = word.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            letters[i]++;
        }
        String pushedWord = new String(letters);
        return pushedWord;
    }
}
