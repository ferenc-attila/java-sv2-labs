package methodstructure.pendrives;

import java.util.List;

public class Pendrives {

    public Pendrive getBest(List<Pendrive> pendrives) {
        Pendrive bestPendrive = pendrives.get(0);
        for (Pendrive actual : pendrives) {
            if (bestPendrive.comparePricePerCapacity(actual) > 0) {
                bestPendrive = actual;
            }
        }
        return bestPendrive;
    }

    public Pendrive getCheapest(List<Pendrive> pendrives) {
        Pendrive cheapestPendrive = pendrives.get(0);
        for (Pendrive actual : pendrives) {
            if (actual.isCheaperThan(cheapestPendrive)) {
                cheapestPendrive = actual;
            }
        }
        return cheapestPendrive;
    }

    public void risePriceWhereCapacity(List<Pendrive> pendrives, int percent, int capacity) {
        for (Pendrive actual : pendrives) {
            if (actual.getCapacity() == capacity) {
                actual.risePrice(percent);
            }
        }
    }
}
