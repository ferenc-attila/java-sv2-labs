package references.parameters;

public class ReferencesMain {

    public static void main(String[] args) {

        Person personOne;
        Person personTwo;

        Person personThree = new Person("John Doe", 45);
        personOne = personThree;
        personTwo = personOne;

        personTwo.setName("Jane Doe");

        System.out.println(personOne.getName());
        System.out.println(personTwo.getName());
        System.out.println(personThree.getName());
    }
}
