package references.dogs;

public class Dog {

    private String name;
    private int age;
    private String colour;

    public Dog(String name, int age, String colour) {
        this.name = name;
        this.age = age;
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "name: " + name + ";\n" +
               "age: " + age + ";\n" +
               "colour: " + colour + ";\n";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
