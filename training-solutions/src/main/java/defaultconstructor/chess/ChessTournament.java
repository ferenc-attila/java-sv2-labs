package defaultconstructor.chess;

import java.util.Arrays;
import java.util.List;

public class ChessTournament {

    private List<Team> teams;

    public ChessTournament() {
        teams = Arrays.asList(new Team(), new Team(), new Team());
    }

    public void addPlayersToTeams(List<Player> playersRegistrated) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < playersRegistrated.size(); j++) {
                setPlayers(playersRegistrated, i, j);
            }
        }
    }

    public List<Team> getTeams() {
        return teams;
    }

    private void setPlayers(List<Player> playersRegistrated, int i, int j) {
        if (j == i * 2) {
            teams.get(i).setPlayerOne(playersRegistrated.get(j));
        }
        if (j == i * 2 + 1) {
            teams.get(i).setPlayerTwo(playersRegistrated.get(j));
        }
    }
}
