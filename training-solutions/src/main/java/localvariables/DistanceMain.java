package localvariables;

public class DistanceMain {

    public static void main(String[] args) {

        Distance distance = new Distance(5.547, false);
        System.out.println("The distance is " + distance.getDistanceInKm() + " km and " + distance.isExact() + ".");

        int distanceInteger = (int) distance.getDistanceInKm();

        System.out.println(distanceInteger);
    }
}
