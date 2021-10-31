package stringscanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IntScanner {

    public String convertInts(String ints) {
        List<String> integerStringList = new ArrayList<>();
        Scanner scanner = new Scanner(ints).useDelimiter(";");
        while (scanner.hasNext()) {
            integerStringList.add(scanner.next());
        }
        StringBuilder intListBuilder = new StringBuilder();
        boolean first = true;
        for (String integerString : integerStringList) {
            if (Integer.parseInt(integerString) > 100) {
                if (first) {
                    first = false;
                } else {
                    intListBuilder.append(",");
                }
                intListBuilder.append(integerString);
            }
        }
        return intListBuilder.toString();
    }
}
