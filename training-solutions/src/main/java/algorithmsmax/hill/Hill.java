package algorithmsmax.hill;

import java.util.List;

public class Hill {

    public int getMax(List<Integer> hillHeights) {
        int maxHeight = Integer.MIN_VALUE;
        for (int height : hillHeights) {
            if (height > maxHeight) {
                maxHeight = height;
            }
        }
        return maxHeight;
    }
}
