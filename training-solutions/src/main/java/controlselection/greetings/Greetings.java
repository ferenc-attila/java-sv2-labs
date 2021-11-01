package controlselection.greetings;

import java.time.LocalTime;

public class Greetings {

    public String Greeting(LocalTime time) {
        LocalTime endOfNight = LocalTime.of(5, 00);
        LocalTime endOfMorning = LocalTime.of(9, 00);
        LocalTime endOfDay = LocalTime.parse("18:30");
        LocalTime endOfEvening = LocalTime.parse("20:00");
        if (time.isAfter(endOfNight) && time.isBefore(endOfMorning)) {
            return "Jó reggelt!";
        } else if (time.isAfter(endOfMorning) && time.isBefore(endOfDay)) {
            return "Jó napot!";
        } else if (time.isAfter(endOfDay) && time.isBefore(endOfEvening)) {
            return "Jó estét!";
        } else {
            return "Jó éjt!";
        }
    }
}
