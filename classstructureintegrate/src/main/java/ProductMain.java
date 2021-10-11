import java.util.Scanner;

public class ProductMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Kérlek, add meg az első termék nevét!");
        String name = scanner.nextLine();

        System.out.println("Kérlek, add meg az első termék árát!");
        int price = scanner.nextInt();
        scanner.nextLine();

        Product firstProduct = new Product(name, price);
        System.out.println("Az első termék neve " + firstProduct.getName() + ", ára " + firstProduct.getPrice() + " Ft.");

        System.out.println("Kérlek, add meg a második termék nevét!");
        name = scanner.nextLine();

        System.out.println("Kérlek, add meg a második termék árát!");
        price = scanner.nextInt();
        scanner.nextLine();

        Product secondProduct = new Product(name, price);
        System.out.println("A második termék neve " + secondProduct.getName() + ", ára " + secondProduct.getPrice() + " Ft.");

        firstProduct.increasePrice(25);
        secondProduct.increasePrice(40);

        System.out.println("Az első termék (" + firstProduct.getName() + ") új, megemelt ára " + firstProduct.getPrice() + " Ft.");
        System.out.println("A második termék (" + secondProduct.getName() + ") új, megemelt ára " + secondProduct.getPrice() + " Ft.");

        firstProduct.decreasePrice(34);
        secondProduct.decreasePrice(29);

        System.out.println("Az első termék (" + firstProduct.getName() + ") új, csökkentett ára " + firstProduct.getPrice() + " Ft.");
        System.out.println("A második termék (" + secondProduct.getName() + ") új, csökkentett ára " + secondProduct.getPrice() + " Ft.");

    }
}
