package collectionsequalshash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WebShop {

    private List<Product> products = new ArrayList<>();

    public WebShop(List<Product> products) {
        this.products = products;
    }

    public int findHowMany(Product product) {
        int count = 0;
        for (Product actual : products) {
            if (product.equals(actual)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>(Arrays.asList(new Product("telefon", "123456"),
                new Product("webkamera", "123456"),
                new Product("billentyűzet", "123456"),
                new Product("monitor", "234567")));

        WebShop shop = new WebShop(products);

        System.out.println(shop.findHowMany(new Product("laptop", "123456")));
        System.out.println(shop.findHowMany(new Product("tablet", "234567")));
    }
}
