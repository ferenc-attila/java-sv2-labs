package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Client {

    private static final int MIN_AGE = 11;
    private static final int MAX_AGE = 149;
    private static final int LENGTH_OF_SOCIAL_SECURITY_NUMBER = 9;
    private static final int MIN_DAYS_BETWEEN_VACCINATIONS = 14;

    private Long id;
    private String name;
    private String postalCode;
    private int age;
    private String email;
    private String socialSecurityNumber;
    private int numberOfVaccinations;
    private LocalDate lastVaccination;

    public Client(String name, String postalCode, int age, String email, String socialSecurityNumber) {
        validateParameters(name, postalCode, age, email, socialSecurityNumber);
        this.name = name;
        this.postalCode = postalCode;
        this.age = age;
        this.email = email;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public Client(Long id, String name, String postalCode, int age, String email, String socialSecurityNumber, int numberOfVaccinations, LocalDate lastVaccination) {
        this(name, postalCode, age, email, socialSecurityNumber);
        this.id = id;
        this.numberOfVaccinations = numberOfVaccinations;
        this.lastVaccination = lastVaccination;
    }

    private void validateParameters(String name, String postalCode, int age, String email, String socialSecurityNumber) {
        validateName(name);
        validatePostalCode(postalCode);
        validateAge(age);
        validateEmail(email);
        validateSocialSecurityNumber(socialSecurityNumber);
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty!");
        }
    }

    private String validatePostalCode(String postalCode) {
        if (postalCode == null || postalCode.isBlank()) {
            throw new IllegalArgumentException("Postal code cannot be empty!");
        }
        // Get list of municipalities from table and return name of municipality!
        // If not in the list, throw new exception!
        return "town";
    }

    private void validateAge(int age) {
        if (age < MIN_AGE || age > MAX_AGE) {
            throw new IllegalArgumentException("Age must be between " + MIN_AGE + " and " + MAX_AGE + "!");
        }
    }

    private void validateEmail(String email) {
        if (email == null || email.isBlank() || email.length() < 5 || email.indexOf('@') < 1 || email.indexOf('.') < 3) {
            throw new IllegalArgumentException("Invalid e-mail address: " + email + "!");
        }
    }

    private void validateSocialSecurityNumber(String socialSecurityNumber) {
        if (socialSecurityNumber == null || socialSecurityNumber.length() != LENGTH_OF_SOCIAL_SECURITY_NUMBER) {
            throw new IllegalArgumentException("Social security number must consist of 9 numeric characters!");
        }
        validateCdvCode(socialSecurityNumber);
    }

    private void validateCdvCode(String socialSecurityNumber) {
        List<Integer> valuesOfSocialSecurityNumber = getValuesOfSocialSecurityNumber(socialSecurityNumber);
        int cdvCode = getCdvCode(valuesOfSocialSecurityNumber);
        if (cdvCode != valuesOfSocialSecurityNumber.get(LENGTH_OF_SOCIAL_SECURITY_NUMBER - 1)) {
            throw new IllegalArgumentException("Invalid CDV code in social security number!");
        }
    }

    private int getCdvCode(List<Integer> valuesOfSocialSecurityNumber) {
        int cdvCode = 0;
        for (int i = 0; i < LENGTH_OF_SOCIAL_SECURITY_NUMBER - 1; i++) {
            if (i % 2 == 0) {
                cdvCode += valuesOfSocialSecurityNumber.get(i) * 3;
            } else {
                cdvCode += valuesOfSocialSecurityNumber.get(i) * 7;
            }
        }
        cdvCode = cdvCode % 10;
        return cdvCode;
    }

    private List<Integer> getValuesOfSocialSecurityNumber(String socialSecurityNumber) {
        List<Integer> valuesOfSocialSecurityNumber = new ArrayList<>();
        try {
            for (int i = 0; i < LENGTH_OF_SOCIAL_SECURITY_NUMBER; i++) {
                valuesOfSocialSecurityNumber.add(Integer.parseInt(socialSecurityNumber.substring(i, i + 1)));
            }
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Invalid character in social security number!", nfe);
        }
        return valuesOfSocialSecurityNumber;
    }

    public boolean canGetVaccination(LocalDate date) {
        return  (this.lastVaccination == null || lastVaccination.plusDays(MIN_DAYS_BETWEEN_VACCINATIONS).isBefore(date));
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public int getNumberOfVaccinations() {
        return numberOfVaccinations;
    }

    public void setNumberOfVaccinations(int numberOfVaccinations) {
        this.numberOfVaccinations = numberOfVaccinations;
    }

    public LocalDate getLastVaccination() {
        return lastVaccination;
    }

    public void setLastVaccination(LocalDate lastVaccination) {
        this.lastVaccination = lastVaccination;
    }
}
