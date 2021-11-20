package introexceptioncheckedtrace;

import java.io.IOException;
import java.util.List;

public class Underground {

    public static void main(String[] args) {

        Operations operations = new Operations();

        try {
            List<String> subwayCars = operations.readFile();
            String dailySchedule = operations.getDailySchedule(subwayCars);
            System.out.println(dailySchedule);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
