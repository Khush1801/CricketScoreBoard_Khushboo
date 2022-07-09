package service;

import dto.Player;
import dto.Team;

public class ScoreCard {
    public void printScoreCard(Team team1, Team team2)
    {
        System.out.println("Individual Player Details are as follows for " + team1.getName());
        System.out.println("================================================");
        for(Player player : team1.getPlayers()){
            System.out.println("Player " + player.getName() + ":");
            System.out.println("| Runs Scored = " + player.getRuns() +
                    "| Fours = " + player.getFours() +
                    "| Sixes = " + player.getSixes() +
                    "| Balls Played = " + player.getBallsPlayed() + " |");
            System.out.println("----------------------------------------------");
        }
        System.out.println("Wickets taken by " + team2.getName() + " are: " + team2.totalWicketsTaken());
        for(Player player : team2.getPlayers()){
            System.out.println("Player " + player.getName() + ":");
            System.out.println("| Wickets Taken = " + player.getWicketsTaken() + "| Balls Thrown = " + player.getBallsThrown());
            System.out.println("----------------------------------------------");
        }
        System.out.println("================================================");
        System.out.println("Total Score is " + team1.getScore());
        System.out.println("Total wickets out is " + team1.totalWickets());
        System.out.println("Total Wide balls played is " + team1.getWideBallsPlayed());
        System.out.println("Total No balls played is " + team1.getNoBallsPlayed());
        System.out.println("================================================");
    }

    public void printWinner(Team team1, Team team2){
        System.out.println("================================================");
        System.out.println("RESULT");
        System.out.println("================================================");
        if(team1.getScore() > team2.getScore()){
            System.out.println(team1.getName() + " won by " +  (team1.getScore() - team2.getScore()) + " runs");
        }
        else if(team2.getScore() > team1.getScore()){
            System.out.println(team2.getName() + " won by " +  (team2.getScore() - team1.getScore()) + " runs");
        }
        else {
            System.out.println("Match tie!!!!!!!!!!!!");
        }
        System.out.println("================================================");
    }
}
