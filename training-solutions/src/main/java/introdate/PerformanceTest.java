package introdate;

import java.time.LocalDate;
import java.time.LocalTime;

public class PerformanceTest {

    public static void main(String[] args) {

    LocalDate date = LocalDate.of(2021, 10, 21);
    LocalTime startTime = LocalTime.of(19,00);
    LocalTime endTime = LocalTime.of(22,00);

    Performance performance = new Performance(date, "Nightwish", startTime, endTime);

        System.out.println(performance.getInfo());
    }


}
