package introexceptionthrow.patient;

public class SsnValidator {

    public boolean isValid(String ssn) {
        if (ssn.length() != 9) {
            return false;
        }
        int[] numbers;
        try {
            numbers = createNumberArray(ssn);
        } catch (NumberFormatException nfe) {
            System.out.println(ssn + " contains non-numeric character!");
            nfe.getMessage();
            nfe.printStackTrace();
            return false;
        }
        double checkCode = getCheckCode(ssn, numbers);
        return checkCode % 10 == numbers[ssn.length() - 1];
    }

    private double getCheckCode(String ssn, int[] numbers) {
        double checkCode = 0;
        for (int i = 0; i < ssn.length() - 1; i++) {
            if (i % 2 == 0) {
                checkCode += numbers[i] * 3;
            } else {
                checkCode += numbers[i] * 7;
            }
        }
        return checkCode;
    }

    private int[] createNumberArray(String ssn) {
        int[] numbers = new int[ssn.length()];
        for (int i = 0; i < ssn.length(); i++) {
            int number = Integer.parseInt(ssn.substring(i, i + 1));
            numbers[i] = number;
        }
        return numbers;
    }
}
