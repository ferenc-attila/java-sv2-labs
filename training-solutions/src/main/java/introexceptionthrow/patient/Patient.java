package introexceptionthrow.patient;

public class Patient {

    public static final int MINIMUM_YEAR_OF_BIRTH = 1900;

    private String name;
    private String socialSecurityNumber;
    private int yearOfBirth;

    public Patient(String name, String ssn, int yearOfBirth) {
        name = name.trim();
        throwNameException(name);
        this.name = name;
        ssn = ssn.trim();
        throwSsnException(ssn);
        this.socialSecurityNumber = ssn;
        throwYearOfBirthException(yearOfBirth);
        this.yearOfBirth = yearOfBirth;
    }

    public static void main(String[] args) {
        Patient jane = new Patient("Jane", "012345678", 1900);
//        Patient patient = new Patient("", "012345678", 1980);
//        Patient joe = new Patient("Joe", "012345678", 1899);
//        Patient jack = new Patient("Jack", "12345678", 2000);
//        Patient jill = new Patient("jill", "O12345678", 1985);
//        Patient judy = new Patient("judy", "112345678", 1979);
        Patient janice = new Patient("Janice", "012345678", 1901);
    }

    private void throwNameException(String name) {
        if ("".equals(name)) {
            throw new IllegalArgumentException("Name is empty!");
        }
    }

    private void throwSsnException(String ssn) {
        SsnValidator ssnValidator = new SsnValidator();
        if (!ssnValidator.isValid(ssn)) {
            throw new IllegalArgumentException(ssn + " is not a valid Social Security Number!");
        }
    }

    private void throwYearOfBirthException(int yearOfBirth) {
        if (yearOfBirth < MINIMUM_YEAR_OF_BIRTH) {
            throw new IllegalArgumentException(illegalYearOfBirthErrorMessage(yearOfBirth));
        }
    }

    private String illegalYearOfBirthErrorMessage(int yearOfBirth) {
        StringBuilder errorMessage = new StringBuilder("Year of birth must be larger than ");
        errorMessage.append(MINIMUM_YEAR_OF_BIRTH - 1).append(". You entered ").append(yearOfBirth).append("!");
        return errorMessage.toString();
    }
}
