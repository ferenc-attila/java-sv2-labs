package services.vaccinationorder;

import services.registration.Client;
import services.vaccination.Vaccination;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;

public class VaccinationOrder {

    private static final long MAX_NUMBER_OF_VACCINATIONS_PER_DAY = 16;
    private static final long TIME_OF_A_VACCINATION = 30;
    private static final LocalTime FIRST_VACCINATION_TIME = LocalTime.of(8, 0);

    private String postalCode;
    private LocalDate date;
    private List<Vaccination> vaccinations;

    public VaccinationOrder(String postalCode, LocalDate date, List<Client> clients) {
        this.postalCode = postalCode;
        this.date = date;
        this.vaccinations = createListOfVaccinationsByClients(clients);
    }

    private List<Vaccination> createListOfVaccinationsByClients(List<Client> clients) {
         List<Vaccination> result = clients.stream()
                .filter(client -> client.getPostalCode().equals(this.postalCode))
                .filter(client -> client.canGetVaccination(this.date))
                .map(Vaccination::new)
                .toList();
         return getOrderedVaccination(result);
    }

    private List<Vaccination> getOrderedVaccination(List<Vaccination> vaccinations) {
        List<Vaccination> result = vaccinations.stream()
                .sorted(Comparator.<Vaccination, Integer>comparing(vaccination -> vaccination.getClient().getAge()).reversed()
                        .thenComparing(vaccination -> vaccination.getClient().getName()))
                .limit(MAX_NUMBER_OF_VACCINATIONS_PER_DAY)
                .toList();
        calculateVaccinationTime(result);
        return result;
    }

    private void calculateVaccinationTime(List<Vaccination> result) {
        for (int i = 0; i < result.size(); i++) {
            result.get(i).setVaccinationDateTime(LocalDateTime.of(date, FIRST_VACCINATION_TIME.plusMinutes(i * TIME_OF_A_VACCINATION)));
        }
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
