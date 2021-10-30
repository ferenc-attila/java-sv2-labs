package enumtype.position;

public enum Position {

    SALESMANAGER(500_000, "Cafeteria, Free lunch, Car"), LEADINGDEVELOPER(1_000_000, "Cafeteria, Health services, Free lunch"), MARKETINGMANAGER(750_000, "Cafeteria, Free lunch, Car"), CEO(2_000_000, "Cafeteria, Health services, Car");

    private int salary;
    private String benefit;

    Position(int salary, String benefit) {
        this.salary = salary;
        this.benefit = benefit;
    }

    public int getSalary() {
        return salary;
    }

    public String getBenefit() {
        return benefit;
    }
}
