package formatlocaleprintf;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public class Run {

    List<Double> kms;
    String name;

    public Run(List<Double> kms, String name) {
        this.kms = kms;
        this.name = name;
    }

    public void addRun(double km) {
        kms.add(km);
    }

    public String printFormattedRunText() {
        return new String().format(new Locale("hu", "HU"),
                "Kedves %s! A mai dátum: %s. Ezen a héten ez a(z) %d. futásod. Most %3.1f km-t futottál. Csak így tovább!",
                name, LocalDate.now(), kms.size(), kms.get(kms.size() - 1));
    }
}
