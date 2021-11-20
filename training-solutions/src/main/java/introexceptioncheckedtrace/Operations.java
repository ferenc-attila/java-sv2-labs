package introexceptioncheckedtrace;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

public class Operations {

    public List<String> readFile () throws IOException {
        return Files.readAllLines(Paths.get("underground.txt"));
    }

    public String getDailySchedule (List<String> fileContent) {
        StringBuilder dailySchedule = new StringBuilder(LocalDate.now().toString());
        dailySchedule.append(", ");
        for (String row : fileContent) {
            if (row.charAt(0) == '2') {
                dailySchedule.append(row);
                dailySchedule.append(" ");
            }
        }
        return dailySchedule.toString();
    }
}
