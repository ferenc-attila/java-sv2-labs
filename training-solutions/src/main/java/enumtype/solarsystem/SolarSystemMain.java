package enumtype.solarsystem;

public class SolarSystemMain {

    public static void main(String[] args) {

        for (SolarSystem planet : SolarSystem.values()) {
            System.out.print(planet + ": " + planet.getNumberOfMoons());
            System.out.println();
        }

        int numberOfMoons = 0;
        for (SolarSystem planet : SolarSystem.values()) {
            numberOfMoons = numberOfMoons + planet.getNumberOfMoons();
        }

        System.out.println(numberOfMoons);

        System.out.println(SolarSystem.valueOf("MARS"));

        System.out.println(SolarSystem.EARTH.getNumberOfMoons());
    }
}
