package collectionscomp;

public class Student {

    private String name;
    private int height;

    public Student(String name, int height) {
        this.name = name;
        this.height = height;
    }

    @Override
    public String toString() {
        return name + ": " + height + " cm";
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }
}
