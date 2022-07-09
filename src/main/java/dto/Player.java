package dto;

public class Player {
    private String name;
    private int runs;
    private int fours;
    private int sixes;
    private int ballsPlayed;
    private Team team;
    private Status playerStatus = Status.Waiting;
    private int battingOrder;
    private int noBallsPlayed;
    private int wideBallsPlayed;
    private int ballsThrown;

    private int wideBallsThrown;

    private int noBallsThrown;

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

    private int runsGiven;

    private int wicketsTaken;

    public int getWicketsTaken() {
        return wicketsTaken;
    }

    public void setWicketsTaken(int wicketsTaken) {
        this.wicketsTaken = wicketsTaken;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getFours() {
        return fours;
    }

    public void setFours(int fours) {
        this.fours = fours;
    }

    public int getSixes() {
        return sixes;
    }

    public void setSixes(int sixes) {
        this.sixes = sixes;
    }

    public int getBallsPlayed() {
        return ballsPlayed;
    }

    public void setBallsPlayed(int ballsPlayed) {
        this.ballsPlayed = ballsPlayed;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Status getPlayerStatus() {
        return playerStatus;
    }

    public void setPlayerStatus(Status playerStatus) {
        this.playerStatus = playerStatus;
    }

    public int getBattingOrder() {
        return battingOrder;
    }

    public void setBattingOrder(int battingOrder) {
        this.battingOrder = battingOrder;
    }

    public int getNoBallsPlayed() {
        return noBallsPlayed;
    }

    public void setNoBallsPlayed(int noBallsPlayed) {
        this.noBallsPlayed = noBallsPlayed;
    }

    public int getWideBallsPlayed() {
        return wideBallsPlayed;
    }

    public void setWideBallsPlayed(int wideBallsPlayed) {
        this.wideBallsPlayed = wideBallsPlayed;
    }

    public int getBallsThrown() {
        return ballsThrown;
    }

    public void setBallsThrown(int ballsThrown) {
        this.ballsThrown = ballsThrown;
    }

    public int getRunsGiven() {
        return runsGiven;
    }

    public void setRunsGiven(int runsGiven) {
        this.runsGiven = runsGiven;
    }

   public Player(String name, Team team){
        setTeam(team);
        setName(name);
    }

    public void runsScoredWhileBowling(int runs){
        runsGiven += runs;
    }

    public void wicketTaken(){
        wicketsTaken++;
    }

    public void ballThrown(){
        ballsThrown++;
    }
}
