package introexceptionthrow;

public class Validation {

    public void validateName(String name) {
        name = name.trim();
        if ("".equals(name)) {
            throw new IllegalArgumentException("Name is empty!");
        }
    }

    public void validateAge(String ageString) {
        ageString = ageString.trim();
        if ("".equals(ageString)) {
            throw new IllegalArgumentException("Age is empty!");
        } else if (!isNotNegativeNumber(ageString)) {
            throw new IllegalArgumentException(("Age must be a valid positive number or 0!"));
        } else if (Integer.parseInt(ageString) > 120) {
            throw new IllegalArgumentException("Age must be between 0 and 120!");
        }
    }

    private boolean isNotNegativeNumber(String numberString) {
        char[] characters = numberString.toCharArray();
        for (char character : characters) {
            if (!Character.isDigit(character)) {
                return false;
            }
        }
        return true;
    }
}
