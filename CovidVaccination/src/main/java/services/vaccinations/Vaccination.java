package services.vaccinations;

import services.registration.Client;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Vaccination {

    private static final int MIN_DAYS_BETWEEN_VACCINATIONS = 15;

    private String postalCode;
    private List<Client> clients = new ArrayList<>();
    private LocalDateTime date;

    public Vaccination(String postalCode) {
        this.postalCode = postalCode;
    }

    public void addClient (Client client) {
        validateClient(client);
        clients.add(client);
    }

    private void validateClient(Client client) {
        if (client.getLastVaccination() == null || client.getLastVaccination().plusDays(MIN_DAYS_BETWEEN_VACCINATIONS).isAfter(date.toLocalDate())) {
            throw new IllegalArgumentException("Client must wait!");
        }
    }

    public String getPostalCode() {
        return postalCode;
    }

    public List<Client> getClients() {
        return List.copyOf(clients);
    }
}
