package collectionsiterator;

import java.util.Iterator;
import java.util.List;

public class ChristmasShopping {

    private List<ChristmasPresent> presents;

    public ChristmasShopping(List<ChristmasPresent> presents) {
        this.presents = presents;
    }

    public void addNewPresent(ChristmasPresent present) {
        presents.add(present);
    }

    public void removeTooExpensivePresent(int maxPrice) {
        for (Iterator<ChristmasPresent> iterator = presents.iterator(); iterator.hasNext(); ) {
            ChristmasPresent actual = iterator.next();
            if (actual.getPrice() > maxPrice) {
                iterator.remove();
            }
        }
    }

    public List<ChristmasPresent> getPresents() {
        return List.copyOf(presents);
    }
}
