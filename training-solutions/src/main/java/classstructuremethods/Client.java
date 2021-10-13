package classstructuremethods;

public class Client {

    private String name;
    private int year;
    private String address;

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getAddress() {
        return address;
    }

    public void changeName (String name) {
        this.name = name;
    }

    public void changeYear (int year) {
        this.year = year;
    }

    public void changeAddress (String address) {
        this.address = address;
    }

    public void migrate (String address) {
        this.address = address;
    }

}
