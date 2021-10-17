package conventions;

public class Car {

    private String carType;
    private String engineType;
    private int doors;
    private int persons;

    public Car(String carType, String engineType, int doors, int persons) {
        this.carType = carType;
        this.engineType = engineType;
        this.doors = doors;
        this.persons = persons;
    }

    public String getCarType() {
        return carType;
    }

    public String GetEngineType() {
        return engineType;
    }

    public int getPersons() {
        return persons;
    }

    public int getdoors() {
        return doors;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public void SetDoors(int doors) {
        this.doors = doors;
    }

    public void SetPersonS(int persons) {
        this.persons = persons;
    }

    public void addModelName(String MODELName) {
        this.carType = carType + " " + MODELName;
    }
}