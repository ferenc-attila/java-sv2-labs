package nestedclasses.thermo;

public class Thermometer {

    private String nameOfRoom;
    private int temperature;
    private ThermometerObserver observer = null;

    public Thermometer(String nameOfRoom, int temperature) {
        this.nameOfRoom = nameOfRoom;
        this.temperature = temperature;
    }

    public void setThermometerObserver(ThermometerObserver observer) {
        this.observer = observer;
        onTemperatureChanged();
    }

    public void onTemperatureChanged() {
        if (observer != null) {
            observer.handleTemperatureChange(temperature, nameOfRoom);
        }
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        onTemperatureChanged();
    }

    public String getNameOfRoom() {
        return nameOfRoom;
    }

    public double getTemperature() {
        return temperature;
    }

    public ThermometerObserver getObserver() {
        return observer;
    }
}
