package polymorphism.river;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Danube extends River{

    private List<String> capitals;

    public Danube(String name, int length, List<String> capitals) {
        super(name, length);
        this.capitals = capitals;
    }

    public List<String> getCapitals() {
        return capitals;
    }

    public static void main(String[] args) {
        Water water = new Danube("Duna", 2415, new ArrayList<>(Arrays.asList("Vienna", "Bratislava", "Budapest")));
        River river = new Danube("Duna", 2415, new ArrayList<>(Arrays.asList("Bécs", "Pozsony", "Budapest")));
        Danube danube = new Danube("Duna", 2415, new ArrayList<>(Arrays.asList("Bécs", "Pozsony", "Budapest")));

        System.out.println(water.getClass());
        System.out.println(river.getClass());
        System.out.println(river.getLength());
        System.out.println(river.getName());
        System.out.println(danube.getClass());
        System.out.println(danube.getLength());
        System.out.println(danube.getName());
        System.out.println(danube.getCapitals());
    }
}
