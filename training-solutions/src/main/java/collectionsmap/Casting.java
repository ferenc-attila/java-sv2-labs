package collectionsmap;

import java.util.Map;

public class Casting {

    public String callNextApplicant(int lastNumber, Map<Integer, String> applicants) {
        int next = Integer.MAX_VALUE;
        for (Integer actual : applicants.keySet()) {
            if (actual > lastNumber && actual < next) {
                next = actual;
            }
        }
        return applicants.get(next);
    }
}
