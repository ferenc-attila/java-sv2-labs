package methodvarargs.examstats;

public class ExamStats {

    private int maxPoints;

    public ExamStats(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public int getNumberOfTopGrades(int limitInPercent, int... results) {
        checkResults(results);
        int numberOfTopGrades = 0;
        for (int result : results) {
            if (result >= ((double) maxPoints * limitInPercent) / 100) {
                numberOfTopGrades++;
            }
        }
        return numberOfTopGrades;
    }

    public boolean hasAnyFailed(int limitInPercent, int... results) {
        checkResults(results);
        for (int result : results) {
            if (result < ((double) maxPoints * limitInPercent) / 100) {
                return true;
            }
        }
        return false;
    }

    private void checkResults(int[] results) {
        if (results == null || results.length == 0) {
            throw new IllegalArgumentException("Number of results must not be empty!");
        }
    }
}
