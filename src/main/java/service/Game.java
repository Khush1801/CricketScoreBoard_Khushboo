package service;

import dto.Team;

import java.util.List;

public class Game {
    ScoreCard scoreCard = new ScoreCard();
    public void playGame(Team team1, Team team2){
        HalfMatch(team1, team2);
        HalfMatch(team2, team1);
        scoreCard.printWinner(team1, team2);
    }

    public void HalfMatch(Team battingTeam, Team bowlingTeam){
        List<List<String>> overs = battingTeam.getBattingOverDetails();
        for(int i=0;i<overs.size();i++){
            System.out.println("================================================");
            System.out.println(battingTeam.getName()+" is batting for over number " + (i+1));
            bowlingTeam.nextBowler(i);
            playOver(battingTeam, bowlingTeam, overs.get(i));
        }
    }

    public void playOver(Team battingTeam, Team bowlingTeam, List<String> over){
        for(int i=0;i<over.size();i++){
            battingTeam.getOnStrike().setBallsPlayed(battingTeam.getOnStrike().getBallsPlayed()+1);
            battingTeam.setBallsPlayed(battingTeam.getBallsPlayed()+1);
            if(over.get(i).equals("W")){
                battingTeam.wicketOut();
                bowlingTeam.tookWicket();
            }
            else if(over.get(i).equals("Wd")){
                battingTeam.widePlayed();
                bowlingTeam.wideThrown();
            }
            else if(over.get(i).equals("Nb")){
                battingTeam.noBallPlayed();
                bowlingTeam.noBallthrown();
            }
            else if(over.get(i).equals("4")){
                battingTeam.fourHit();
            }
            else if(over.get(i).equals("6")){
                battingTeam.sixHit();
            }
            else if(over.get(i).equals("1")){
                battingTeam.getOnStrike().setRuns(battingTeam.getOnStrike().getRuns()+1);
                battingTeam.setScore(battingTeam.getScore()+1);
                battingTeam.changeStrike();
            }
            else if(over.get(i).equals("3")){
                battingTeam.getOnStrike().setRuns(battingTeam.getOnStrike().getRuns()+3);
                battingTeam.setScore(battingTeam.getScore()+3);
                battingTeam.changeStrike();
            }
            else if(over.get(i).equals("2")){
                battingTeam.getOnStrike().setRuns(battingTeam.getOnStrike().getRuns()+2);
                battingTeam.setScore(battingTeam.getScore()+2);
            }
            bowlingTeam.getBowler().setBallsThrown(bowlingTeam.getBowler().getBallsThrown()+1);
        }
        battingTeam.changeStrike();
        scoreCard.printScoreCard(battingTeam, bowlingTeam);
    }
}
