package enumtype.position;

import java.util.Arrays;

public class PositionMain {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(Position.values()));

        for (Position pos : Position.values()) {
            System.out.println(pos + ": salary: " + pos.getSalary() + "; benefits: " + pos.getBenefit());
        }
    }
}
