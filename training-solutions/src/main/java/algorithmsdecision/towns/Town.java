package algorithmsdecision.towns;

import java.util.List;

public class Town {

    public boolean containsFewerHabitants(List<Integer> populations, int limit) {
        for (int population : populations) {
            if (population < limit) {
                return true;
            }
        }
        return false;
    }
}
