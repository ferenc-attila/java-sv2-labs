package datenewtypes;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.*;

public class FamilyBirthdays {

    private List<LocalDate> birthdays;

    public FamilyBirthdays(LocalDate... birthdays) {
        this.birthdays = Arrays.asList(birthdays);
    }

    public boolean isFamilyBirthday(TemporalAccessor date) {
        return (!birthdays.stream()
                .filter(birthday -> birthday.get(ChronoField.MONTH_OF_YEAR) == date.get(ChronoField.MONTH_OF_YEAR))
                .filter(birthday -> birthday.get(ChronoField.DAY_OF_MONTH) == date.get(ChronoField.DAY_OF_MONTH))
                .toList().isEmpty());
    }

    public int nextFamilyBirthDay(TemporalAccessor date) {
        List<LocalDate> nextBirthdays = new ArrayList<>();
        LocalDate reference = LocalDate.of(date.get(ChronoField.YEAR), date.get(ChronoField.MONTH_OF_YEAR), date.get(ChronoField.DAY_OF_MONTH));

        defineBirthdaysInActualYear(nextBirthdays, reference);
        defineBirthdaysAfterReference(nextBirthdays, reference);
        LocalDate nextBirthday = getClosestBirthday(nextBirthdays);

        return (int) (ChronoUnit.DAYS.between(reference, nextBirthday));
    }

    private LocalDate getClosestBirthday(List<LocalDate> nextBirthDays) {
        return nextBirthDays.stream()
                .min(Comparator.naturalOrder()).orElseThrow(() -> new IllegalArgumentException("Empty list"));
    }

    private void defineBirthdaysAfterReference(List<LocalDate> nextBirthDays, LocalDate reference) {
        nextBirthDays.addAll(nextBirthDays.stream()
                .filter(reference::isAfter)
                .map(birthday -> LocalDate.of(birthday.plusYears(1).getYear(), birthday.getMonth(), birthday.getDayOfMonth()))
                .toList());
        nextBirthDays.removeIf(reference::isAfter);
    }

    private void defineBirthdaysInActualYear(List<LocalDate> nextBirthDays, LocalDate reference) {
        nextBirthDays.addAll(birthdays.stream()
                .map(birthday -> LocalDate.of(reference.getYear(), birthday.getMonth(), birthday.getDayOfMonth()))
                .toList());
    }
}
