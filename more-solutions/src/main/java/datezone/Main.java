package datezone;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

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
        
    }
}
