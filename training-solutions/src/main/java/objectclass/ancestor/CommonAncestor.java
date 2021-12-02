package objectclass.ancestor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CommonAncestor {

    public static void main(String[] args) {
        List<Object> objects = new ArrayList<>();

        Fruit fruit = new Fruit();
        objects.add(fruit);
        Apple apple = new Apple();
        objects.add(apple);
        Starking starking = new Starking();
        objects.add(starking);
        Vegetable vegetable = new Vegetable();
        objects.add(vegetable);
        objects.add("alma");
        objects.add(12);
        objects.add('x');
        objects.add(LocalDate.now());
        List<String> strings = new ArrayList<>();
        objects.add(strings);

        System.out.println(objects);
    }
}
