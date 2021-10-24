package finalmodifier;

import java.util.Arrays;
import java.util.List;

public class Week {

    public static void main(String[] args) {
        List<String> days = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");

        days.set(1, days.get(2));
        System.out.println(days);
    }
}
