package arraylist;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Freezer {

    public static void main(String[] args) {

        List<String> foodList = new ArrayList<>();

        String[] foodArray = {"chicken breast", "green peas", "fried cheese", "green beans", "french fries"};
        for (String food: foodArray) {
            foodList.add(food);
        }

//        foodList.add("chicken breast");
//        foodList.add("green peas");
//        foodList.add("fried cheese");
//        foodList.add("green beans");
//        foodList.add("french fries");

        System.out.println(foodList);

        foodList.remove(0);
        foodList.remove(3);

        System.out.println(foodList);
        System.out.println(foodList.size());
    }
}
