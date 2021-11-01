package stringscanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringScanner {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.println("Kérlek, adj meg egy öszetett mondatot!");
        String sentence = s.nextLine();
        List<String> words = new ArrayList<>();
        Scanner sentenceScanner = new Scanner(sentence);
        while (sentenceScanner.hasNext()) {
            words.add(sentenceScanner.next());
        }

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

        Scanner sc = new Scanner(System.in);
        System.out.println("Kérlek, adj meg egy másik öszetett mondatot!");
        String anotherSentence = sc.nextLine();
        List<String> clauses = new ArrayList<>();
        Scanner anotherSentenceScanner = new Scanner(anotherSentence).useDelimiter(", ");
        while (anotherSentenceScanner.hasNext()) {
            clauses.add(anotherSentenceScanner.next());
        }

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
