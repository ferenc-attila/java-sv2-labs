package algorithmsmax.temperature;

import java.util.List;

public class Temperature {

    public int getMin(List<Integer> tempList) {
        int minTemp = Integer.MAX_VALUE;
        for (int temp : tempList) {
            if (temp < minTemp) {
                minTemp = temp;
            }
        }
        return minTemp;
    }
}
