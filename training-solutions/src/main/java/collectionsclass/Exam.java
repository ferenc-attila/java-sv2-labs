package collectionsclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Exam {

    private List<ExamResult> results;

    public Exam(List<ExamResult> results) {
        this.results = results;
    }

    public List<String> getNamesOfSucceededPeople(int places) {
        List<String> succeeded = new ArrayList<>();
        sortResults();
        if (places > results.size()) {
            addSucceededPeople(results.size(), succeeded);
        } else {
            addSucceededPeople(places, succeeded);
        }
        return succeeded;
    }

    private void addSucceededPeople(int places, List<String> succeeded) {
        for (int i = 0; i < places; i++) {
            succeeded.add(results.get(i).getName());
        }
    }

    private void sortResults() {
        Collections.sort(results, new Comparator<ExamResult>() {
            @Override
            public int compare(ExamResult o1, ExamResult o2) {
                return o2.getResult() - o1.getResult();
            }
        });
    }
}
