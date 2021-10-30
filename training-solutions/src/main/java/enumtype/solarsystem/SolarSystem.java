package enumtype.solarsystem;

public enum SolarSystem {

    MERCURY(0), VENUS(0), EARTH(1), MARS(2), JUPITER(79), SATURN(82), URANUS(27), NEPTUNE(14);

    private final int numberOfMoons;

    SolarSystem(int numberOfMoons) {
        this.numberOfMoons = numberOfMoons;
    }

    public int getNumberOfMoons() {
        return numberOfMoons;
    }
}
