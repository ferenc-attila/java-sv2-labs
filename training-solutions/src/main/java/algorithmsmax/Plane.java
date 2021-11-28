package algorithmsmax;

public class Plane {

    public int getLongestOcean(String map) {
        int max = 0;
        int sizeOfOcean = 0;
        char[] mapArray = map.toCharArray();
        for (char c : mapArray) {
            if (c == '0') {
                sizeOfOcean++;
            }
            if (c == '1' && sizeOfOcean > max) {
                max = sizeOfOcean;
            }
            if (c == '1') {
                sizeOfOcean = 0;
            }
        }
        return max;
    }
}
