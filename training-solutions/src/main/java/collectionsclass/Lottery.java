package collectionsclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottery {

    private List<Integer> numbers = new ArrayList<>();

    public List<Integer> selectWinningNumbers(int lotteryType, int ballCount) {
        validateParameters(lotteryType, ballCount);
        createNumbers(ballCount);
        Collections.shuffle(numbers);
        List<Integer> winningNumbers = new ArrayList<>();
        for (int i = 0; i < lotteryType; i++) {
            winningNumbers.add(numbers.get(i));
        }
        Collections.sort(winningNumbers);
        return List.copyOf(winningNumbers);
    }

    private void validateParameters(int lotteryType, int ballCount) {
        if (lotteryType >= ballCount) {
            throw new IllegalArgumentException("There must be more balls than the winning numbers!");
        }
    }

    private void createNumbers(int ballCount) {
        for (int i = 1; i <= ballCount; i++) {
            numbers.add(i);
        }
    }
}
