package introexceptiontrycatchtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Winner {

    private List<String> names = new ArrayList<>(Arrays.asList("Jane Doe", "John Doe", "", null, "Jill Doe"));

    public String getWinner() {
        Random random = new Random();
        int i = random.nextInt(names.size());
        String winner = (names.get(i));
        return winner.toUpperCase();
    }

    public List<String> getNames() {
        return names;
    }
}
