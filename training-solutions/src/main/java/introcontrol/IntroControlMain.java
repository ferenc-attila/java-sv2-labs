package introcontrol;

public class IntroControlMain {

    public static void main(String[] args) {

        IntroControl introcontrol = new IntroControl();

        System.out.print("subtractTenIfGreaterThanTen if number less than 10 (5): ");
        System.out.println(introcontrol.subtractTenIfGreaterThanTen(5));
        System.out.print("subtractTenIfGreaterThanTen if number greater than 10 (21): ");
        System.out.println(introcontrol.subtractTenIfGreaterThanTen(21));
        System.out.println();

        System.out.print("describeNumber if number equals 0: ");
        System.out.println(introcontrol.describeNumber(0));
        System.out.print("describeNumber if number not equals 0 (-3): ");
        System.out.println(introcontrol.describeNumber(-3));
        System.out.println();

        System.out.print("greetingToJoe if name is Joe: ");
        System.out.println(introcontrol.greetingToJoe("Joe"));
        System.out.print("greetingToJoe if name not Joe (Jack): ");
        System.out.println(introcontrol.greetingToJoe("Jack"));
        System.out.println();

        System.out.print("calculateBonus if sale = 1 000 000: ");
        System.out.println(introcontrol.calculateBonus(1_000_000));
        System.out.print("calculateBonus if sale > 1 000 000 (1 100 000): ");
        System.out.println(introcontrol.calculateBonus(1_100_000));
        System.out.print("calculateBonus if sale < 1 000 000 (900 000): ");
        System.out.println(introcontrol.calculateBonus(900_000));
        System.out.println();

        System.out.print("calculateConsumption if next >= prev (1100, 4300): ");
        System.out.println(introcontrol.calculateConsumption(1100, 4300));
        System.out.print("calculateConsumption if next < prev (4300, 1100): ");
        System.out.println(introcontrol.calculateConsumption(4300, 1100));
        System.out.println();

        System.out.println("printNumbers (12):");
        introcontrol.printNumbers(12);
        System.out.println();

        System.out.println("printNumbersBetween (5, 13):");
        introcontrol.printNumbersBetween(5, 13);
        System.out.println();

        System.out.println("printNumbersBetweenAnyDirection, a < b (3, 8):");
        introcontrol.printNumbersBetweenAnyDirection(3, 8);
        System.out.println("printNumbersBetweenAnyDirection, a > b (9, 2):");
        introcontrol.printNumbersBetweenAnyDirection(9, 2);
        System.out.println();

        System.out.println("printOddNumbers, max is odd (11):");
        introcontrol.printOddNumbers(11);
        System.out.println("printOddNumbers, max is even (16):");
        introcontrol.printOddNumbers(16);
    }
}
