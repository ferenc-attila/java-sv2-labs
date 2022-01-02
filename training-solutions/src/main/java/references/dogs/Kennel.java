package references.dogs;

import java.util.ArrayList;
import java.util.List;

public class Kennel {

    public static void main(String[] args) {

        List<Dog> dogs = new ArrayList<>();

        Dog dog1 = new Dog("Csöpi", 5, "zsemle");
        Dog dog2 = new Dog("Bogáncs", 7, "fekete");
        Dog dog3 = new Dog("Cserge", 6, "fehér");

        dogs.add(dog1);
        dogs.add(dog2);
        dogs.add(dog3);
//        System.out.println(dogs);

        Dog dog4 = dogs.get(1);
        dogs.add(dog4);
//        System.out.println(dogs);

        Dog dog5 = new Dog("Hektor", 8, "szürke");
//        System.out.println(dog5);

        dog5 = dogs.get(1);
        dogs.add(dog5);
//        System.out.println(dogs);

        Dog dog6 = dog4;
        dog6.setColour("szürke");
//        dogs.add(dog6);
//        System.out.println(dogs);

        List<Dog> dogs2 = new ArrayList<>();
        dogs2 = dogs;

        Dog dog7 = dog4;
        dog7.setColour("csokoládé");
//        System.out.println(dogs2);

        dog2.setColour("barna");
//        System.out.println(dogs2);

        dog2 = null;
//        System.out.println(dogs2);

        Dog dog8 = dogs.get(1);
        dog8 = null;
//        System.out.println(dogs2);

        Dog dog9 = dogs.get(1);
        dog9.setColour("fekete");
//        System.out.println(dogs2);

//        System.out.println(dog2);
//        dog2.setColour("fehér");
        System.out.println(dog2);
        System.out.println(dogs);
    }
}
