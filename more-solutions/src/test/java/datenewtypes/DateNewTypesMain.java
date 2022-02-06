package datenewtypes;

import java.time.LocalDate;
import java.util.Locale;

public class DateNewTypesMain {

    public static void main(String[] args) {
        DateOfBirth dateOfBirth = new DateOfBirth(1980,5,12);
        DateOfBirth anotherDateOfBirth = new DateOfBirth(1979, 7,8);

        System.out.println(dateOfBirth.findDayOfWeekForBirthDate(new Locale("hu", "HU")));
        System.out.println(anotherDateOfBirth.findDayOfWeekForBirthDate(Locale.ENGLISH));

        System.out.println(dateOfBirth.isWeekDay());
        System.out.println(anotherDateOfBirth.isWeekDay());

        System.out.println(dateOfBirth.wasItAtLeapYear());
        System.out.println(anotherDateOfBirth.wasItAtLeapYear());

        System.out.println(dateOfBirth.findBirthDayOfWeekLater(42));

        System.out.println(dateOfBirth.countDaysSinceBirth(LocalDate.now()));

        System.out.println(dateOfBirth.countDaysBetween(anotherDateOfBirth));
        System.out.println(anotherDateOfBirth.countDaysBetween(dateOfBirth));
        System.out.println(dateOfBirth.countDaysBetween(dateOfBirth));

        System.out.println(dateOfBirth.toString("yyyy.MM.dd"));
    }
}
