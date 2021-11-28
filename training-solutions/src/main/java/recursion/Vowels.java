package recursion;

public class Vowels {

    public int getNumberOfVowels(String word) {
        String lowerCaseWord = word.toLowerCase();
        String vowels = "aáeéiíoóöőuúüű";
        if (lowerCaseWord.length() == 0) {
            return 0;
        } else if (vowels.indexOf(lowerCaseWord.charAt(0)) > -1) {
            return 1 + getNumberOfVowels(lowerCaseWord.substring(1));
        } else {
            return getNumberOfVowels(lowerCaseWord.substring(1));
        }
    }
}
