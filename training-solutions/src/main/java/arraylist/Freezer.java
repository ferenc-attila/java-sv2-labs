package arraylist;

import java.util.List;
import java.util.ArrayList;

public class Freezer {

    public static void main(String[] args) {

        List<String> foodList = new ArrayList<>();

        String[] foodArray = {"chicken breast", "green peas", "fried cheese", "green beans", "french fries"};
        for (String food : foodArray) {
            foodList.add(food);
        }

        System.out.println(foodList);
        System.out.println(foodList.size());

        foodList.remove(0);
        foodList.remove(3);

        System.out.println(foodList);
        System.out.println(foodList.size());
    }
}
