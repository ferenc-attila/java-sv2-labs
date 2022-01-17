package sorting;

import java.time.LocalDateTime;

public class Patient {

    private String name;
    private String socialSecurityNumber;
    private LocalDateTime appointment;

    public Patient(String name, String socialSecurityNumber, LocalDateTime appointment) {
        this.name = name;
        this.socialSecurityNumber = socialSecurityNumber;
        this.appointment = appointment;
    }


    public String getName() {
        return name;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public LocalDateTime getAppointment() {
        return appointment;
    }
}
