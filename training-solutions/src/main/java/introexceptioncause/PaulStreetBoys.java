package introexceptioncause;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class PaulStreetBoys {

    public static void main(String[] args) {

        PaulStreetBoys names = new PaulStreetBoys();

        try {
            List<String> paulStreetBoysNames = names.readNames();
            System.out.println(names.printNames(paulStreetBoysNames));
        } catch (IllegalStateException ise) {
            System.out.println(ise.getMessage());
//            ise.printStackTrace();
            ise.getCause().printStackTrace();
        }
    }

    private List<String> readNames() {
        try {
            return Files.readAllLines(Paths.get("src/main/resources/palutcaifiuk.txt"));
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file", ioe);
        }
    }

    private String printNames(List<String> names) {
        StringBuilder print = new StringBuilder();
        boolean first = true;
        for (String row : names) {
            if (row.equals("Nemecsek")) {
                row = row.toLowerCase();
            }
            if (first) {
                print.append(row);
                first = false;
            } else {
                print.append(", ").append(row);
            }
        }
        return print.toString();
    }
}
