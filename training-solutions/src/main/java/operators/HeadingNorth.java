package operators;

public class HeadingNorth {

    public int getNumberOfNewDirections() {
        int heading = 10;
        int numberOfTurns = 1;
        for (int i = 20; (heading % 360) != 0; i += 10) {
            heading += i;
            numberOfTurns++;
        }
        return numberOfTurns;
    }
}
