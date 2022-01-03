package isahasa.fleet;

import java.util.ArrayList;
import java.util.List;

public class Fleet {

    private List<Ship> ships = new ArrayList<>();
    private int waitingPeople;
    private int waitingCargo;

    public void addShip (Ship ship) {
        ships.add(ship);
    }

    public void loadShip (int passengers, int cargoWeight) {
        for (Ship ship : ships) {
            if (ship.getClass() == Liner.class) {
                passengers = ((Liner) ship).loadPassenger(passengers);
            } else if (ship.getClass() == CargoShip.class) {
                cargoWeight = ((CargoShip) ship).loadCargo(cargoWeight);
            } else if (ship.getClass() == FerryBoat.class) {
                cargoWeight = ((FerryBoat) ship).loadCargo(cargoWeight);
                passengers = ((FerryBoat) ship).loadPassenger(passengers);
            }
        }
        this.waitingPeople = passengers;
        this.waitingCargo = cargoWeight;
    }

    public int getWaitingPeople() {
        return waitingPeople;
    }

    public int getWaitingCargo() {
        return waitingCargo;
    }
}
