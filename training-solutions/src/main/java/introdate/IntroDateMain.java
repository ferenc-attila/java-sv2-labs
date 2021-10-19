package introdate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class IntroDateMain {

    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2000, Month.JANUARY, 31);
        LocalDate anotherDate = LocalDate.of(2020, 2, 28);
        System.out.println(date);
        System.out.println(anotherDate);

        LocalDate now = LocalDate.now();
        System.out.println(now);

        LocalTime time = LocalTime.of(2, 30);
        System.out.println(time);

        LocalDateTime dateTime = LocalDateTime.of(2020, 5, 20, 14, 21, 12, 956);
        System.out.println(dateTime);

        LocalDateTime dateTimeNow = LocalDateTime.now();
        System.out.println(dateTimeNow);

        System.out.println(date.equals(anotherDate));

    }
}
