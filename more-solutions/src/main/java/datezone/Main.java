package datezone;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        System.out.println(ZoneId.systemDefault());
        System.out.println(ZoneId.getAvailableZoneIds());
        System.out.println(ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault()));
        ZonedDateTime time = ZonedDateTime.of(LocalDateTime.of(2017,3,26,2,25), ZoneId.systemDefault());
        System.out.println(time);

        ZonedDateTime autumnTime = ZonedDateTime.of(LocalDateTime.of(2017,10,29,2,25), ZoneId.systemDefault());
        System.out.println(autumnTime);
        System.out.println(autumnTime.plusHours(1));

        WorkHoursCalculator c = new WorkHoursCalculator(2017, Month.OCTOBER,29, 2,ZoneId.systemDefault());
        System.out.println(c.calculateHours(2017,Month.OCTOBER,29, 3));

        System.out.println(System.currentTimeMillis());
        System.out.println(Arrays.stream(Locale.getAvailableLocales()).map(Locale::getLanguage).toList());

        ZoneId winter = ZoneId.of("UTC+1");
        ZoneId summer = ZoneId.of("UTC+2");
        ZonedDateTime dateTime = ZonedDateTime.of(LocalDateTime.now(), winter);
//
        System.out.println(dateTime);
        System.out.println(dateTime.withZoneSameInstant(summer));
    }
}
