package isahasa.fleet;

import java.util.ArrayList;
import java.util.List;

public class Fleet {

    private List<Ship> ships = new ArrayList<>();
    private int waitingPeople;
    private int waitingCargo;

    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public void loadShip(int passengers, int cargoWeight) {
        int remainingPersons = passengers;
        int remainingCargo = cargoWeight;
        for (Ship ship : ships) {
            if (ship instanceof CanCarryPassengers) {
                remainingPersons = getRemainingPersons(remainingPersons, (CanCarryPassengers) ship);
            }
            if (ship instanceof CanCarryGoods) {
                remainingCargo = getRemainingCargo(remainingCargo, (CanCarryGoods) ship);
            }
            this.waitingPeople = remainingPersons;
            this.waitingCargo = remainingCargo;
        }
    }

    private int getRemainingCargo(int remainingCargo, CanCarryGoods ship) {
        if (remainingCargo != 0) {
            remainingCargo = ship.loadCargo(remainingCargo);
        }
        return remainingCargo;
    }

    private int getRemainingPersons(int remainingPersons, CanCarryPassengers ship) {
        if (remainingPersons != 0) {
            remainingPersons = ship.loadPassenger(remainingPersons);
        }
        return remainingPersons;
    }

    public int getWaitingCargo() {
        return waitingCargo;
    }

    public int getWaitingPeople() {
        return waitingPeople;
    }
}
