package interfaces.simpletasks;

import java.util.ArrayList;
import java.util.List;

public class SimpleTasks implements Runnable {

    private List<String> tasks;

    public SimpleTasks(List<String> tasks) {
        this.tasks = tasks;
    }

    @Override
    public void run() {
        while (nextStep()) {
            nextStep();
        }
    }

    private boolean nextStep() {
        if (!tasks.isEmpty()) {
            tasks.remove(tasks.size() - 1);
            return true;
        }
        return false;
    }

    public List<String> getTasks() {
        return new ArrayList<>(tasks);
    }
}
