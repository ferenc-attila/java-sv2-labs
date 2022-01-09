package exceptionmulticatch.aid;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Aid {

    private int amount;

    public Aid(int amount) {
        this.amount = amount;
    }

    public List<String> countAmountsOfAid(Path path) {
        List<String> amountsOfAid = new ArrayList<>();
        List<String> populations = readFile(path);
        createListOfAmountsPerPerson(amountsOfAid, populations);
        return amountsOfAid;
    }

    private void createListOfAmountsPerPerson(List<String> amountsOfAid, List<String> populations) {
        for (String actual : populations) {
            int population;
            int amountPerPerson;
            String[] row;
            try {
                row = actual.split(": ");
                population = Integer.parseInt(row[1]);
                amountPerPerson = amount / population;
            } catch (NumberFormatException | NullPointerException | ArithmeticException | ArrayIndexOutOfBoundsException ex) {
                throw new IllegalStateException("Something went wrong while counting.", ex);
            }
            amountsOfAid.add(row[0] + ": " + amountPerPerson);
        }
    }

    private List<String> readFile(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException | NullPointerException ex) {
            throw new IllegalStateException("Something went wrong while counting.", ex);
        }
    }
}
