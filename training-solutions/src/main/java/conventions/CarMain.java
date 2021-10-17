package conventions;

import java.util.Scanner;

public class CarMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the manufacturer of your old car:");
        String type = scanner.nextLine();
        System.out.println("Enter the engine type of your old car:");
        String engine = scanner.nextLine();
        System.out.println("Enter the number of doors on your old car:");
        int doors = scanner.nextInt();
        scanner.nextLine();
        System.out.println(("Enter the number of persons your old car can carry:"));
        int persons = scanner.nextInt();
        scanner.nextLine();

        Car car = new Car(type, engine, doors, persons);

        System.out.println("You added the following data about your old car:");
        System.out.println("Manufacturer: " + car.getCarType() + ";");
        System.out.println("Engine type: " + car.getEngineType() + ";");
        System.out.println("Number of doors: " + car.getDoors() + ";");
        System.out.println("Number of seats: " + car.getPersons() + ";");

        System.out.println("Enter the ");

        System.out.println("Enter the manufacturer of your new car:");
        String newType = scanner.nextLine();
        System.out.println("Enter the engine type of your new car:");
        String newEngine = scanner.nextLine();
        System.out.println("Enter the number of doors on your new car:");
        int newDoors = scanner.nextInt();
        scanner.nextLine();
        System.out.println(("Enter the number of persons your new car can carry:"));
        int newPersons = scanner.nextInt();
        scanner.nextLine();

        car.setCarType(newType);
        car.setEngineType(newEngine);
        car.setDoors(newDoors);
        car.setPersons(newPersons);

        System.out.println("You added the following data about your new car:");
        System.out.println("Manufacturer: " + car.getCarType() + ";");
        System.out.println("Engine type: " + car.getEngineType() + ";");
        System.out.println("Number of doors: " + car.getDoors() + ";");
        System.out.println("Number of seats: " + car.getPersons() + ";");

        System.out.println("Enter the model name of your new car:");
        String newModel = scanner.nextLine();

        car.addModelName(newModel);

        System.out.println("The modified type of your car is " + car.getCarType() + ";");

    }
}
