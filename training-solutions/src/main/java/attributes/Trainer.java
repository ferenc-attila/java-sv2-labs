package attributes;

import java.util.List;

public class Trainer {

    private String name;
    private boolean active;
    private List<Training> training;

    public Trainer(String name, boolean active, List<Training> training) {
        this.name = name;
        this.active = active;
        this.training = training;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public List<Training> getTraining() {
        return training;
    }
}
