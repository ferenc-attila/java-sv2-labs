package stringseparate;

import java.util.List;

public class Codes {

    public String getCodesStartWithLetter(List<String> codes) {
        StringBuilder codesStartWithLetter = new StringBuilder("Codes start with letter: ");
        boolean first = true;
        for (String code : codes) {
            if (Character.isAlphabetic(code.charAt(0))) {
                if (first) {
                    first = false;
                } else {
                    codesStartWithLetter.append(", ");
                }
                codesStartWithLetter.append(code);
            }
        }
        return codesStartWithLetter.toString();
    }
}
