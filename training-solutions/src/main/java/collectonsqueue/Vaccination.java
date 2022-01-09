package collectonsqueue;

import java.util.*;

public class Vaccination {

    public Queue<Integer> getVaccinationOrder(List<Person> people) {
        Queue<Integer> order = new PriorityQueue<>();
        for (Person actual : people) {
            if (actual.getAge() >= 18 && actual.getAge() <= 65) {
                order.add(actual.getAge());
            }
        }
        return order;
    }

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(Arrays.asList(new Person("Tóth Jánosné", 82),
                new Person ("Szabó Marianna", 18),
                new Person ("Tóth Miklós", 45),
                new Person ("Hegyi Barbara", 14),
                new Person ("Lakatos Izabella", 65),
                new Person ("Arató Virág", 35)));

        Vaccination vaccination = new Vaccination();

        Queue<Integer> vaccinationOrder = vaccination.getVaccinationOrder(people);

        System.out.println(vaccinationOrder);

        System.out.println(vaccinationOrder.poll());
        System.out.println(vaccinationOrder.poll());
        System.out.println(vaccinationOrder.poll());
        System.out.println(vaccinationOrder.poll());
    }
}
