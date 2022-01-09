package collectionsset;

import java.util.*;

public class QuestionGame {

    private List<RightAnswer> answers;
    private Random rn = new Random();

    public QuestionGame(List<RightAnswer> answers) {
        this.answers = answers;
    }

    public Set<String> drawWinners() {
        Set<String> winners = new HashSet<>();
        while (winners.size() < 5) {
            validateAnswersSize();
            drawing(winners);
        }
        return winners;
    }

    private void drawing(Set<String> winners) {
        RightAnswer winner = answers.get(rn.nextInt(0, answers.size()));
        answers.remove(winner);
        winners.add(winner.getName());
    }

    private void validateAnswersSize() {
        if (answers == null || answers.isEmpty()) {
            throw new IllegalArgumentException("Not enough right answers!");
        }
    }

    public List<RightAnswer> getAnswers() {
        return List.copyOf(answers);
    }
}
