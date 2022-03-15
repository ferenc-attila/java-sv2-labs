package services.vaccinationorder;

import services.vaccination.Vaccination;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class VaccinationOrder {

    private static final int MIN_DAYS_BETWEEN_VACCINATIONS = 15;

    private String postalCode;
    private List<Vaccination> vaccinations = new ArrayList<>();
    private LocalDate date;

    public VaccinationOrder(String postalCode, LocalDate date) {
        this.postalCode = postalCode;
        this.date = date;
    }

    public void addVaccination(Vaccination vaccination) {
        validateVaccination(vaccination);
        vaccinations.add(vaccination);
    }

    private void validateVaccination(Vaccination vaccination) {
        if (vaccination.getClient().getLastVaccination() != null && vaccination.getClient().getLastVaccination().plusDays(MIN_DAYS_BETWEEN_VACCINATIONS).isAfter(date)) {
            throw new IllegalArgumentException("Client must wait for next vaccination!");
        }
    }

    public List<Vaccination> getOrderedVaccination() {
        vaccinations
                .sort(Comparator.<Vaccination, Integer>comparing(vaccination -> vaccination.getClient().getAge()).reversed()
                        .thenComparing(vaccination -> vaccination.getClient().getName()));
        return List.copyOf(vaccinations);
    }

    public String getPostalCode() {
        return postalCode;
    }

    public List<Vaccination> getVaccinations() {
        return List.copyOf(vaccinations);
    }

    public LocalDate getDate() {
        return date;
    }
}
