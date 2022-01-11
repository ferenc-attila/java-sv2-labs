package collectionsmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class ClassTrip {

    private Map<String, Integer> inpayments = new HashMap<>();

    public void loadInpayments(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            parsePayment(br);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        } catch (NumberFormatException | NullPointerException exception) {
            throw new IllegalArgumentException("Invalid data in the file!", exception);
        }
    }

    private void parsePayment(BufferedReader br) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            String[] payment = line.split(": ");
            inpayments.put(payment[0], Integer.parseInt(payment[1]));
        }
    }

    public Map<String, Integer> getInpayments() {
        return inpayments;
    }
}
