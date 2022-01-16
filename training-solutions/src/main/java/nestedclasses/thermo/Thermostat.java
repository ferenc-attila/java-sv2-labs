package nestedclasses.thermo;

import java.util.ArrayList;
import java.util.List;

public class Thermostat {

    private List<String> roomsToHeat;
    private List<Thermometer> thermometers;
    private int temperatureLimit;

    public Thermostat() {
        this.roomsToHeat = new ArrayList<>();
        this.thermometers = new ArrayList<>();
        this.temperatureLimit = 23;
    }

    public void addThermometer(Thermometer thermometer) {
        thermometer.setThermometerObserver(new ThermometerObserver() {
            @Override
            public void handleTemperatureChange(int temp, String room) {
                if (roomsToHeat.contains(room) && temp >= temperatureLimit) {
                    roomsToHeat.remove(room);
                }
                if (!roomsToHeat.contains(room) && temp < temperatureLimit) {
                    roomsToHeat.add(room);
                }
            }
        });
        thermometers.add(thermometer);
    }

    public List<String> getRoomsToHeat() {
        return List.copyOf(roomsToHeat);
    }
}
