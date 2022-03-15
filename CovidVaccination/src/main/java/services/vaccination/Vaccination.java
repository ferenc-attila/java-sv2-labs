package services.vaccination;

import services.registration.Client;

import java.time.LocalDateTime;

public class Vaccination {

    private Long id;
    private Client client;
    private LocalDateTime vaccinationDateTime;
    private Status status;
    private String note;
    private VaccineType vaccineType;

    public Vaccination(Long id, Client client, LocalDateTime vaccinationDateTime, Status status, String note, VaccineType vaccineType) {
        this.id = id;
        this.client = client;
        this.vaccinationDateTime = vaccinationDateTime;
        this.status = status;
        this.note = note;
        this.vaccineType = vaccineType;
    }

    public Long getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public LocalDateTime getVaccinationDateTime() {
        return vaccinationDateTime;
    }

    public Status getStatus() {
        return status;
    }

    public String getNote() {
        return note;
    }

    public VaccineType getVaccineType() {
        return vaccineType;
    }
}
