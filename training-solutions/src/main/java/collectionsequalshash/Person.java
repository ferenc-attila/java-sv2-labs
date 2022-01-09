package collectionsequalshash;

import java.util.Objects;

public class Person {

    private String name;
    private int age;
    private final String socialSecurityNumber;

    public Person(String name, int age, String socialSecurityNumber) {
        this.name = name;
        this.age = age;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public static void main(String[] args) {
        Person janeYoung = new Person("Jane Doe", 17, "123456");
        Person janeOlder = new Person("Jane Smith", 38, "123456");

        System.out.println(janeOlder.equals(janeYoung));
        System.out.println(janeYoung.hashCode());
        System.out.println(janeOlder.hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return socialSecurityNumber.equals(person.socialSecurityNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(socialSecurityNumber);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }
}
