package com.example.f22comp1011assignment2;

import com.google.gson.annotations.SerializedName;

public class Team
{
    @SerializedName("StandingId")
    private int standingsId;

    @SerializedName("Team")
    private String name;

    @SerializedName("Coach")
    private String coach;

    @SerializedName("Points")
    private int points;

    @SerializedName("Wins")
    private int wins;

    @SerializedName("Losses")
    private int losses;

    @SerializedName("Ties")
    private int ties;

    public Team(int standingsId, String name, String coach, int points, int wins, int losses, int ties)
    {
        setStandingsId(standingsId);
        setName(name);
        setCoach(coach);
        setPoints(points);
        setWins(wins);
        setLosses(losses);
        setTies(ties);
    }

    public int getStandingsId() {
        return standingsId;
    }

    public void setStandingsId(int standingsId) {
        this.standingsId = standingsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String toString()
    {
        return name;
    }

}
