package introexceptionmoreexceptions;

public class PersonMain {

    public static void main(String[] args) {

        Person person = new Person(null, 32);

        System.out.println(person);
        System.out.println(person.getName());
        System.out.println(person.getName().toUpperCase());
    }
}
