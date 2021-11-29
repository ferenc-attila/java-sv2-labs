package methodparam.sums;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SeparatedSum {

    public Results sum(String floatingNumbers) {
        double[] numbers = getDoubles(floatingNumbers);
        double sumOfNegatives = 0;
        double sumOfPositives = 0;
        for (double number : numbers) {
            if (number < 0) {
                sumOfNegatives += number;
            } else {
                sumOfPositives += number;
            }
        }
        return new Results(sumOfNegatives, sumOfPositives);
    }

    private double[] getDoubles(String floatingNumbers) {
        String[] numberStrings = floatingNumbers.replace(',', '.').split(";");
        double[] numbers = new double[numberStrings.length];
        for (int i = 0; i < numberStrings.length; i++) {
            numbers[i] = Double.parseDouble(numberStrings[i]);
        }
        return numbers;
    }

    public String readTextFile(Path path) {
        List<String> contentOfFile;
        try {
            contentOfFile = Files.readAllLines(path);
            return contentOfFile.get(0);
        } catch (IOException ioe) {
            throw new IllegalStateException("Unable to read file", ioe);
        }
    }
}
