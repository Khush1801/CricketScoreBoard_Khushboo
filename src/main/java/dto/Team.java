package dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players = new ArrayList<>();
    private int score;
    private int numPlayers;

    private int wideBallsPlayed;
    private int ballsPlayed;

    private List<List<String>> battingOverDetails;

    private double overs;
    private Player onStrike;
    private Player onNonStrike;
    private int noBallsPlayed;

    private int wideBallsThrown;

    public int getWideBallsThrown() {
        return wideBallsThrown;
    }

    public void setWideBallsThrown(int wideBallsThrown) {
        this.wideBallsThrown = wideBallsThrown;
    }

    public int getNoBallsThrown() {
        return noBallsThrown;
    }

    public void setNoBallsThrown(int noBallsThrown) {
        this.noBallsThrown = noBallsThrown;
    }

    public int getBallThrown() {
        return ballThrown;
    }

    public void setBallThrown(int ballThrown) {
        this.ballThrown = ballThrown;
    }

    private int noBallsThrown;

    private int ballThrown;
    private Player bowler;

    public List<List<String>> getBattingOverDetails() {
        return battingOverDetails;
    }

    public void setBattingOverDetails(List<List<String>> battingOverDetails) {
        this.battingOverDetails = battingOverDetails;
    }

    public double getOvers() {
        return overs;
    }

    public void setOvers(double overs) {
        this.overs = overs;
    }

    public Team(String name, int numPlayers){
        this.name = name;
        this.numPlayers = numPlayers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayers() {
        Collections.sort(players, (a, b)->(a.getBattingOrder()-b.getBattingOrder()));
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public int getWideBallsPlayed() {
        return wideBallsPlayed;
    }

    public void setWideBallsPlayed(int wideBallsPlayed) {
        this.wideBallsPlayed = wideBallsPlayed;
        onStrike.setWideBallsPlayed(onStrike.getWideBallsPlayed()+1);
    }

    public int getBallsPlayed() {
        return ballsPlayed;
    }

    public void setBallsPlayed(int ballsPlayed) {
        this.ballsPlayed = ballsPlayed;
    }

    public Player getOnStrike() {
        return onStrike;
    }

    public void setOnStrike(Player onStrike) {
        this.onStrike = onStrike;
    }

    public Player getOnNonStrike() {
        return onNonStrike;
    }

    public void setOnNonStrike(Player onNonStrike) {
        this.onNonStrike = onNonStrike;
    }

    public int getNoBallsPlayed() {
        return noBallsPlayed;
    }

    public void setNoBallsPlayed(int noBallsPlayed) {
        this.noBallsPlayed = noBallsPlayed;
    }

    public Player getBowler() {
        return bowler;
    }

    public void setBowler(Player bowler) {
        this.bowler = bowler;
    }

    public void setBattingOrder(List<Integer> order){
        for(int i=0;i<order.size();i++){
            players.get(order.get(i)-1).setBattingOrder(i);
        }
        Player next1=null, next2=null;
        Collections.sort(players, (a, b) -> a.getBattingOrder() - b.getBattingOrder());
        for(int i=0;i<numPlayers;i++){
            if (players.get(i).getPlayerStatus().equals(Status.Waiting) && next1 == null) {
                next1=players.get(i);
                players.get(i).setPlayerStatus(Status.Batting);
            }
            else if(players.get(i).getPlayerStatus().equals(Status.Waiting) && next2==null){
                next2 = players.get(i);
                players.get(i).setPlayerStatus(Status.Batting);
            }
        }
        setOnStrike(next1);
        setOnNonStrike(next2);
    }

    public void changeStrike(){
        Player temp = onStrike;
        onStrike = onNonStrike;
        onNonStrike = temp;
    }

    public void wideBallsPlayed(){
        wideBallsPlayed++;
        score++;
    }

    public void wicketOut(){
        this.onStrike.setPlayerStatus(Status.Out);
        Collections.sort(players, (a, b) -> a.getBattingOrder() - b.getBattingOrder());
        for(int i=0;i<numPlayers;i++){
            if(players.get(i).getPlayerStatus().equals(Status.Waiting)){
                this.onStrike = players.get(i);
                players.get(i).setPlayerStatus(Status.Batting);
                break;
            }
        }
    }

    public void tookWicket(){
        bowler.wicketTaken();
    }

    public int totalWickets(){
        int j=0;
        for (int i=0;i<numPlayers;i++){
            if(players.get(i).getPlayerStatus().equals(Status.Out)){
                ++j;
            }
        }
        return j;
    }

    public void setRunsScoredWhileBowling(int runs){
        this.bowler.setRunsGiven(runs);
    }

    public int totalWicketsTaken(){
        int j=0;
        for(int i=0;i<numPlayers;i++){
            j+=players.get(i).getWicketsTaken();
        }
        return j;
    }

    public void nextBowler(int overNum){
        this.bowler = players.get(overNum%numPlayers);
    }

    public void widePlayed(){
        wideBallsPlayed++;
        score++;
        onStrike.setWideBallsPlayed(onStrike.getWideBallsPlayed()+1);
//        onStrike.setRuns(onStrike.getRuns()+1);
    }

    public void wideThrown(){
        wideBallsThrown++;
        bowler.setWideBallsThrown(bowler.getWideBallsThrown()+1);
    }

    public void noBallPlayed(){
        noBallsPlayed++;
        score++;
        onStrike.setNoBallsPlayed(onStrike.getNoBallsPlayed()+1);
//        onStrike.setRuns(onStrike.getRuns()+1);
    }

    public void noBallthrown(){
        noBallsThrown++;
        bowler.setNoBallsThrown(bowler.getNoBallsThrown()+1);
    }

    public void fourHit(){
        score+=4;
        onStrike.setFours(onStrike.getFours()+1);
        onStrike.setRuns(onStrike.getRuns()+4);
    }

    public void sixHit(){
        score+=6;
        onStrike.setSixes(onStrike.getSixes()+1);
        onStrike.setRuns(onStrike.getRuns()+6);
    }

}
