package conventions;

import java.util.Scanner;

public class CarMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the manufacturer of your car:");
        String type = scanner.nextLine();
        System.out.println("Enter the engine type of your car:");
        String engine = scanner.nextLine();
        System.out.println("Enter the number of doors on your car:");
        int doors = scanner.nextInt();
        scanner.nextLine();
        System.out.println(("Enter the number of persons your car can carry:"));
        int persons = scanner.nextInt();
        scanner.nextLine();

        Car car = new Car(type, engine, doors, persons);

        System.out.println("You added the following data about your car:");
        System.out.println("Manufacturer: " + car.getCarType() + ";");
        System.out.println("Engine type: " + car.getEngineType() + ";");
        System.out.println("Number of doors: " + car.getDoors() + ";");
        System.out.println("Number of seats: " + car.getPersons() + ";");


    }
}
