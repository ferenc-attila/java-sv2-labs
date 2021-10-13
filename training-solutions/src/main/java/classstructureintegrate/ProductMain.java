package classstructureintegrate;

import java.util.Scanner;

public class ProductMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert the name of the product:");
        String name = scanner.nextLine();

        System.out.println("Insert the price of the product:");
        int price = scanner.nextInt();
        scanner.nextLine();

        Product product = new Product(name, price);

        System.out.println("The price of the " + product.getName() + ": " + product.getPrice());

        System.out.println("Insert the amount of price increase");
        int increasePrice = scanner.nextInt();

        product.increasePrice(increasePrice);

        System.out.println("The price of the " + product.getName() + ": " + product.getPrice() + " after increase price.");

        System.out.println("Insert the amount of price decrease");
        int decreasePrice = scanner.nextInt();

        product.decreasePrice(decreasePrice);

        System.out.println("The price of the " + product.getName() + ": " + product.getPrice() + " after decrease price.");

    }

}
