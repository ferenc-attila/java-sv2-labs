package stringscanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringScanner {

    public static void main(String[] args) {

        Scanner s = new Scanner("Ez egy olyan mondat, amely több tagmondatból áll, és ezért megfelel a feladatkiírásnak.");

        System.out.println("Kérlek, adj meg egy öszetett mondatot!");
        List<String> words = new ArrayList<>();
        while (s.hasNext()) {
            words.add(s.next());
        }
        System.out.println();

        StringBuilder sentenceBuilderByWords = new StringBuilder();
        boolean first = true;
        for (String word : words) {
            if (first) {
                first = false;
            } else {
                sentenceBuilderByWords.append(" ");
            }
            sentenceBuilderByWords.append(word);
        }
        System.out.println(sentenceBuilderByWords);
        System.out.println();

        Scanner sc = new Scanner("Ez egy olyan mondat, amely több tagmondatból áll, és ezért megfelel a feladatkiírásnak.").useDelimiter(", ");
        System.out.println("Kérlek, adj meg egy másik öszetett mondatot!");

        List<String> clauses = new ArrayList<>();
        while (sc.hasNext()) {
            clauses.add(sc.next());
        }
        System.out.println();

        StringBuilder sentenceBuilderByClause = new StringBuilder();
        for (int i = 0; i < clauses.size(); i++) {
            sentenceBuilderByClause.append(clauses.get(i));
            if (i < clauses.size() - 1) {
                sentenceBuilderByClause.append(", ");
            }
        }
        System.out.println(sentenceBuilderByClause);
    }
}
