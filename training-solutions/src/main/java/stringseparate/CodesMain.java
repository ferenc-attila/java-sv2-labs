package stringseparate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodesMain {

    public static void main(String[] args) {

        Codes codes = new Codes();
        List<String> codeStrings = new ArrayList<>(Arrays.asList("34fgtrK", "T234", "365-45", "/78jbs", "(45lKjZ)", "Fgrta", "KmnFrtz56"));

        System.out.println(codes.getCodesStartWithLetter(codeStrings));
    }
}
