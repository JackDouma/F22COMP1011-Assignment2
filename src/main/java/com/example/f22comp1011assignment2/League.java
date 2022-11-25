package com.example.f22comp1011assignment2;

import com.google.gson.annotations.SerializedName;

public class League
{
    @SerializedName("LeagueId")
    private int leagueId;

    @SerializedName("Name")
    private String name;

    @SerializedName("Sport")
    private String sport;

    @SerializedName("Organizer")
    private String organizer;

    public League(int leagueId, String name, String sport, String organizer)
    {
        setLeagueId(leagueId);
        setName(name);
        setSport(sport);
        setOrganizer(organizer);
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }
}
