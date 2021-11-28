package methodpass.troopers;

import java.util.ArrayList;
import java.util.List;

public class HeadQuarter {

    private List<Trooper> troopers = new ArrayList<>();

    public List<Trooper> getTroopers() {
        return troopers;
    }

    public void addTrooper(Trooper trooper) {
        if (trooper == null) {
            throw new IllegalArgumentException("");
        }
        troopers.add(trooper);
    }

    public void moveTrooperByName(String name, Position target) {
        if (name == null || name.isBlank() || target == null) {
            throw new IllegalArgumentException("");
        }
        Trooper trooper = findTrooperByName(name);
        if (trooper == null) {
            throw new IllegalArgumentException();
        }
        moveTrooper(trooper, target);
    }

    public void moveClosestTrooper(Position target) {
        if (target == null) {
            throw new IllegalArgumentException("");
        }
        Trooper trooper = findClosestTrooper(target);
        if (trooper == null) {
            throw new IllegalArgumentException("");
        }
        moveTrooper(trooper, target);
    }

    private Trooper findTrooperByName(String name) {
        for (Trooper trooper : troopers) {
            if (name.equals(trooper.getName())) {
                return trooper;
            }
        }
        return null;
    }

    private Trooper findClosestTrooper(Position target) {
        Trooper closestTrooper = troopers.get(0);
        for (Trooper trooper : troopers) {
            if (closestTrooper.distanceFrom(target) > trooper.distanceFrom(target)) {
                closestTrooper = trooper;
            }
        }
        return closestTrooper;
    }

    private void moveTrooper(Trooper trooper, Position target) {
        trooper.changePosition(target);
    }
}
