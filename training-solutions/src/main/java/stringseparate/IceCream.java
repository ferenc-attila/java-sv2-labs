package stringseparate;

import java.util.ArrayList;
import java.util.List;

public class IceCream {

    public static void main(String[] args) {
        List<String> iceCreamList = new ArrayList<>();

        iceCreamList.add("chocolate");
        iceCreamList.add("vanilla");
        iceCreamList.add("strawberry");
        iceCreamList.add("lemon");
        iceCreamList.add("caramel");
        iceCreamList.add("coconut");

        StringBuilder advert = new StringBuilder("Available today: ");
        for (int i = 0; i < iceCreamList.size(); i++) {
            advert.append(iceCreamList.get(i));
            if (i != (iceCreamList.size()) - 1) {
                advert.append(", ");
            }
        }
        advert.append(". For children at half price.");

        System.out.println(advert);
    }
}
