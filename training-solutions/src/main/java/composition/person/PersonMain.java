package composition.person;

public class PersonMain {

    public static void main(String[] args) {

        Person firstPerson = new Person("John Doe", "24455AS",
                new Address("Hungary", "Eger", "Kossuth u. 12.", "H3300"));
        System.out.println(firstPerson.personToString());

        firstPerson.correctData("Jack Doe", "45678T9",
                new Address("Hungary", "Budapest", "Váci út 57.", "H1345"));
        System.out.println(firstPerson.personToString());
        firstPerson.getAddress().correctData("Hungary", "Debrecen", "Csapó utca 43.", "H4400");
        System.out.println(firstPerson.personToString());

        firstPerson.moveTo(new Address("UK", "London", "Downing street 12.", "L12345"));
        System.out.println(firstPerson.personToString());

        System.out.println(firstPerson.getAddress().getCountry());
        System.out.println(firstPerson.getAddress().getCity());
        System.out.println(firstPerson.getAddress().getStreetAndNumber());
        System.out.println(firstPerson.getAddress().getZipCode());

        System.out.println(firstPerson.getName());
        System.out.println(firstPerson.getIdentificationCard());
        System.out.println(firstPerson.getAddress().addressToString());


    }
}
