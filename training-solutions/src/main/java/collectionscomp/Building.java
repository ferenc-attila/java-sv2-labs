package collectionscomp;

import java.util.*;

public class Building implements Comparable<Building> {

    private String address;
    private double area;
    private int levels;

    public Building(String address, double area, int levels) {
        this.address = address;
        this.area = area;
        this.levels = levels;
    }

    @Override
    public int compareTo(Building o) {
        return this.levels - o.levels;
    }

    @Override
    public String toString() {
        return address + ": area: " + area + ", levels: " + levels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return levels == building.levels;
    }

    @Override
    public int hashCode() {
        return Objects.hash(levels);
    }

    public String getAddress() {
        return address;
    }

    public double getArea() {
        return area;
    }

    public int getLevels() {
        return levels;
    }

    public static void main(String[] args) {
        Set<Building> buildings = new TreeSet<>(Arrays.asList(
                new Building("Budapest, Ferenc körút 60.", 150.0, 9),
                new Building("Eger, Kallómalom út 12.", 50.0, 4),
                new Building("Kaposvár, Széchenyi út 15.", 100.0, 2),
                new Building("Gyöngyös, Mátralaja utca 21.", 120.0, 20),
                new Building("Nagyréde, Kossuth út 5.", 220.0, 1),
                new Building("Sopron, Várkerület 24.", 110.0, 3))
        );

        System.out.println(buildings);
    }
}
