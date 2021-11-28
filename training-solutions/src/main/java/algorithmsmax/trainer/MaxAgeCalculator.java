package algorithmsmax.trainer;

import java.util.List;

public class MaxAgeCalculator {

    public Trainer getTrainerWithMaxAge(List<Trainer> trainers) {
        Trainer eldest = null;
        int maxAge = 0;
        for (Trainer trainer : trainers) {
            if (maxAge < trainer.getAge()) {
                maxAge = trainer.getAge();
                eldest = trainer;
            }
        }
        return eldest;
    }
}
