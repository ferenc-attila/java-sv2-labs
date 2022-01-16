package nestedclasses.soccer;

import java.util.Objects;

public class TeamStatistics {

    private String teamName;
    private Statistics statistics = new Statistics();

    public TeamStatistics(String teamName) {
        this.teamName = teamName;
    }

    public class Statistics {
        private int played = 0;
        private int won = 0;
        private int tied = 0;
        private int lost = 0;
        private int goalsFor = 0;
        private int goalsAgainst = 0;
        private int points = 0;
    }

    public void played(int plusGoalsFor, int plusGoalsAgainst) {
        statistics.played++;
        statistics.goalsFor += plusGoalsFor;
        statistics.goalsAgainst += plusGoalsAgainst;
        if (plusGoalsFor > plusGoalsAgainst) {
            statistics.won++;
            statistics.points += 3;
        }
        if (plusGoalsFor == plusGoalsAgainst) {
            statistics.tied++;
            statistics.points++;
        }
        if (plusGoalsFor < plusGoalsAgainst) {
            statistics.lost++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamStatistics that = (TeamStatistics) o;
        return teamName.equals(that.teamName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamName);
    }

    public int getPlayed() {
        return statistics.played;
    }

    public int getWon() {
        return statistics.won;
    }

    public int getTied() {
        return statistics.tied;
    }

    public int getLost() {
        return statistics.lost;
    }

    public int getGoalsfor() {
        return statistics.goalsFor;
    }

    public int getGoalsAgainst() {
        return statistics.goalsAgainst;
    }

    public int getPoints() {
        return statistics.points;
    }

    public String getTeamName() {
        return teamName;
    }

    public Statistics getStatistics() {
        return statistics;
    }
}
