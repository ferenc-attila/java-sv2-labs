package nestedclasses.soccer;

import java.util.ArrayList;
import java.util.List;

public class Championship {

    private List<TeamStatistics> leagueTable = new ArrayList<>();

    public static class GameResult {
        private String teamHome;
        private String teamGuest;
        private int goalHome;
        private int goalGuest;

        public GameResult(String teamHome, String teamGuest, int goalHome, int goalGuest) {
            this.teamHome = teamHome;
            this.teamGuest = teamGuest;
            this.goalHome = goalHome;
            this.goalGuest = goalGuest;
        }
    }

    public void addGame(GameResult result) {
        if (!leagueTable.contains(new TeamStatistics(result.teamGuest))) {
            leagueTable.add(new TeamStatistics(result.teamGuest));
        }
        if (!leagueTable.contains(new TeamStatistics(result.teamHome))) {
            leagueTable.add(new TeamStatistics(result.teamHome));
        }
        for (TeamStatistics actual : leagueTable) {
            if (result.teamGuest.equals(actual.getTeamName())) {
                actual.played(result.goalGuest, result.goalHome);
            }
            if (result.teamHome.equals(actual.getTeamName())) {
                actual.played(result.goalHome, result.goalGuest);
            }
        }
    }

    public List<TeamStatistics> getLeagueTable() {
        return List.copyOf(leagueTable);
    }
}
