package formatlocaleprintf;

import java.util.ArrayList;
import java.util.List;

public class RunMain {

    public static void main(String[] args) {

        List<Double> kms = new ArrayList<>();
        Run run = new Run(kms, "Kiss Béla");

        run.addRun(12.3);
        run.addRun(14.5);
        run.addRun(13.8);
        run.addRun(12.8);

        System.out.println(run.printFormattedRunText());
    }
}
