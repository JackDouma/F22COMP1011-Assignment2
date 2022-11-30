package com.example.f22comp1011assignment2;


public class Team
{
    private int standingId;

    private String team;

    private String coach;

    private int points;

    private int wins;

    private int losses;

    private int ties;

    private int leagueId;

    public Team(int standingId, String team, String coach, int points, int wins, int losses, int ties, int leagueId)
    {
        setStandingId(standingId);
        setTeam(team);
        setCoach(coach);
        setPoints(points);
        setWins(wins);
        setLosses(losses);
        setTies(ties);
        setLeagueId(leagueId);
    }

    public int getStandingId() {
        return standingId;
    }

    public void setStandingId(int standingId) {
        this.standingId = standingId;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getTies() {
        return ties;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public String toString()
    {
        return team;
    }

}
