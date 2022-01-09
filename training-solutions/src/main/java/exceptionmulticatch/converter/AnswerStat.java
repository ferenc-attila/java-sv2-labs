package exceptionmulticatch.converter;

public class AnswerStat {

    private BinaryStringConverter converter;

    public AnswerStat(BinaryStringConverter converter) {
        this.converter = converter;
    }

    public boolean[] convert(String binaryString) {
        try {
            return converter.binaryStringToBooleanArray(binaryString);
        } catch (NullPointerException | IllegalArgumentException ex) {
            throw new InvalidBinaryStringException("Invalid binary string.", ex);
        }
    }

    public int answerTruePercent(String answers) {
        boolean[] booleans = convert(answers);
        int countTrueValues = 0;
        for (boolean actual : booleans) {
            if (actual) {
                countTrueValues++;
            }
        }
        return (int) ((double) (countTrueValues) / booleans.length * 100);
    }
}
