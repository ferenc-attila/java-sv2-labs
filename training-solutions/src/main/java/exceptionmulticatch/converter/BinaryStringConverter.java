package exceptionmulticatch.converter;

public class BinaryStringConverter {

    public boolean[] binaryStringToBooleanArray(String binaryString) {
        validateBinaryString(binaryString);
        char[] chars = binaryString.toCharArray();
        return createBooleanArray(chars);
    }

    private boolean[] createBooleanArray(char[] chars) {
        boolean[] booleans = new boolean[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                booleans[i] = false;
            } else if (chars[i] == '1') {
                booleans[i] = true;
            } else {
                throw new IllegalArgumentException("Binary string is not valid.");
            }
        }
        return booleans;
    }

    private void validateBinaryString(String binaryString) {
        if (binaryString == null) {
            throw new NullPointerException("Binary string is null.");
        }
    }

    public String booleanArrayToBinaryString(boolean[] booleans) {
        validateBooleanArray(booleans);
        StringBuilder sb = new StringBuilder();
        for (boolean actual : booleans) {
            if (actual) {
                sb.append(1);
            } else {
                sb.append(0);
            }
        }
        return sb.toString();
    }

    private void validateBooleanArray(boolean[] booleans) {
        if (booleans == null) {
            throw new NullPointerException("Boolean array is null.");
        }
        if (booleans.length == 0) {
            throw new IllegalArgumentException(("Boolean array is empty."));
        }
    }
}
