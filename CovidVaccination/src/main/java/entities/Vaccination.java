package entities;

import java.time.LocalDateTime;

public class Vaccination {

    private Long id;
    private final Client client;
    private LocalDateTime vaccinationDateTime;
    private Status status;
    private String note;
    private VaccineType vaccineType;

    public Vaccination(Client client) {
        this.client = client;
    }

    public Vaccination(Long id, Client client) {
        this.id = id;
        this.client = client;
    }

    public Vaccination(Long id, Client client, LocalDateTime vaccinationDateTime, Status status, String note, VaccineType vaccineType) {
        this(id, client);
        this.vaccinationDateTime = vaccinationDateTime;
        this.status = status;
        validateNote(status, note);
        this.note = note;
        this.vaccineType = vaccineType;
    }

    private void validateNote(Status status, String note) {
        if (status == Status.UNSUCCESSFUL && (note == null || note.isBlank())) {
            throw new IllegalArgumentException("Note cannot be empty, if status was unsuccessful!");
        }
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

    public void setVaccinationDateTime(LocalDateTime vaccinationDateTime) {
        this.vaccinationDateTime = vaccinationDateTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public VaccineType getVaccineType() {
        return vaccineType;
    }

    public void setVaccineType(VaccineType vaccineType) {
        this.vaccineType = vaccineType;
    }
}
