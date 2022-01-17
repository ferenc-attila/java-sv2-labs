package sorting.webshop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WebShop {

    private List<Product> products = new ArrayList<>();

    public void addProducts(Product product) {
        products.add(product);
    }

    public List<Product> getProductsOrderByName() {
        List<Product> sortedByName = new ArrayList<>(products);
        sortedByName.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return sortedByName;
    }

    public List<Product> getProductsOrderByPrice() {
        List<Product> sortedByPrice = new ArrayList<>(products);
        sortedByPrice.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getPrice() - o2.getPrice();
            }
        });
        return sortedByPrice;
    }

    public List<Product> getProductsOrderByDate() {
        List<Product> sortedByFrom = new ArrayList<>(products);
        sortedByFrom.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getFrom().compareTo(o2.getFrom());
            }
        });
        return sortedByFrom;
    }
}
