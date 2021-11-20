package introexceptionthrow;

public class Patient {

    public static final int MINIMUM_YEAR_OF_BIRTH = 1900;

    private String name;
    private String socialSecurityNumber;
    private int yearOfBirth;

    public Patient(String name, String socialSecurityNumber, int yearOfBirth) {
        name = name.trim();
        if ("".equals(name)) {
            throw new IllegalArgumentException("Name is empty!");
        }
        if (yearOfBirth < MINIMUM_YEAR_OF_BIRTH) {
            throw new IllegalArgumentException("Year of birth must be larger than " + (MINIMUM_YEAR_OF_BIRTH - 1) + ". You entered " + yearOfBirth + "!");
        }
        this.name = name;
        this.socialSecurityNumber = socialSecurityNumber;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public static void main(String[] args) {

        Patient janeDoe = new Patient("Jane Doe", "12345678", 1990);

        System.out.println(janeDoe.getName());
        System.out.println(janeDoe.getSocialSecurityNumber());
        System.out.println(janeDoe.getYearOfBirth());

        Patient johnDoe = new Patient("John Doe", "12345678", 1899);

        System.out.println(johnDoe.getName());
        System.out.println(johnDoe.getSocialSecurityNumber());
        System.out.println(johnDoe.getYearOfBirth());

        Patient patient = new Patient("", "1234678", 1900);

        System.out.println(patient.getName());
        System.out.println(patient.getSocialSecurityNumber());
        System.out.println(patient.getYearOfBirth());

    }
}
