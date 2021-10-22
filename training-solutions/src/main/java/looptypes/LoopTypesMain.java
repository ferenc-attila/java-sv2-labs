package looptypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoopTypesMain {

    public static void main(String[] args) {

//        String[] names = {"John", "Jack", "Jane"};
//        for(int i = 0; i < names.length; i++) {
//            System.out.println(names[i]);
//        }

//        for (String name: names) {
//            System.out.println(name);
//        }

        List<String> names = Arrays.asList("John", "Jack", "Jane", "Joe", "Jill", "Bill", "Steve");
//        for (int i=0; i < names.size(); i++) {
//            System.out.println(names.get(i));
//        }
//
//        for (String name: names) {
//            System.out.println(name);
//        }
//
//        for (int i = 0; i< names.size(); i++) {
//            System.out.println((i + 1) + ". " + names.get(i));
//        }

//        for (int i = names.size()-1; i >= 0; i--) {
//            System.out.println(names.get(i));
//        }
//
//        for (int i = names.size()-1; i >=0; i-=2) {
//            System.out.println(names.get(i));
//        }

        List<Integer> numbers = Arrays.asList(1, 2, 5, 3, 3, 8, 6, 9, 9);
        for (int i = 1; i< numbers.size(); i++) {
            if (numbers.get(i) > numbers.get(i-1)) {
                System.out.println("Increase");
            } else if (numbers.get(i) < numbers.get(i-1)) {
                System.out.println("Decrease");
            } else
                System.out.println("Keeps level");
        }
    }
}
