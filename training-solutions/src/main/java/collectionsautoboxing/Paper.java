package collectionsautoboxing;

import java.util.HashMap;
import java.util.Map;

public class Paper {

    private Map<String, Integer> paper = new HashMap<>();

    public void putFurtherPaper(String className, int kilograms) {
        if (paper.containsKey(className)) {
            paper.put(className, paper.get(className) + kilograms);
        } else {
            paper.put(className, kilograms);
        }
    }

    public String getWinnerClass() {
        int maxValue = 0;
        String winner = "";
        for (Map.Entry<String, Integer> actual : paper.entrySet()) {
            if (actual.getValue() > maxValue) {
                maxValue = actual.getValue();
                winner = actual.getKey();
            }
        }
        return winner;
    }

//    public String getWinnerClass() {
//        int maxValue = 0;
//        String winner = "";
//        for (String actual : paper.keySet()) {
//            if (paper.get(actual) > maxValue) {
//                maxValue = paper.get(actual);
//                winner = actual;
//            }
//        }
//        return winner;
//    }

    public int getTotalWeight() {
        int sum = 0;
        for (int actual : paper.values()) {
            sum += actual;
        }
        return sum;
    }

    public Map<String, Integer> getPaper() {
        return Map.copyOf(paper);
    }
}
