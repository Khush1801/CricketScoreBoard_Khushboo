import dto.Player;
import dto.Team;
import service.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String args[]){
        Team team1 = new Team("Team1", 5);
        List<Player> players1 = Arrays.asList(new Player("P1", team1), new Player("P2", team1), new Player("P3", team1),
                new Player("P4", team1), new Player("P5", team1));
        team1.setPlayers(players1);
        List<Integer> battingOrder1 = Arrays.asList(1,2,3,4,5);
        team1.setBattingOrder(battingOrder1);
        List<List<String>> overs1 = Arrays.asList(Arrays.asList("1", "1", "1", "1", "1", "2"), Arrays.asList("W", "4", "4", "Wd", "W", "1", "6"));
        team1.setBattingOverDetails(overs1);

        Team team2 = new Team("Team2", 5);
        List<Player> players2 = Arrays.asList(new Player("P6", team2), new Player("P7", team2), new Player("P8", team2),
                new Player("P9", team2), new Player("P10", team2));
        team2.setPlayers(players2);
        List<Integer> battingOrder2 = Arrays.asList(1,2,3,4,5);
        team2.setBattingOrder(battingOrder2);
        List<List<String>> overs2 = Arrays.asList(Arrays.asList("4", "6", "W", "W", "1", "1"), Arrays.asList("6", "1", "W", "W"));
        team2.setBattingOverDetails(overs2);

        Game game = new Game();
        game.playGame(team1, team2);

    }
}
