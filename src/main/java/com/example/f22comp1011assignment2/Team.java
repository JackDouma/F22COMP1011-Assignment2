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

    /**
     * Constructor
     * @param standingId - standings id
     * @param team - team name
     * @param coach - coach name
     * @param points - points
     * @param wins - wins
     * @param losses - losses
     * @param ties - ties
     * @param leagueId - league id
     */
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

    /**
     * get standings id
     * @return
     */
    public int getStandingId()
    {
        return standingId;
    }

    /**
     * set standings
     * @param standingId
     */
    public void setStandingId(int standingId)
    {
        if (standingId >= 0)
        {
            this.standingId = standingId;
        }
        else
        {
            throw new IllegalArgumentException("Standing ID must not be a negative number.");
        }
    }

    /**
     * get teams
     * @return
     */
    public String getTeam()
    {
        return team;
    }

    /**
     * set team
     * @param team
     */
    public void setTeam(String team)
    {
        if (team.length() > 2 && team.length() < 26)
        {
            this.team = team;
        }
        else
        {
            throw new IllegalArgumentException("Team name must be between 3-25 characters.");
        }
    }

    /**
     * get coach
     * @return
     */
    public String getCoach()
    {
        return coach;
    }

    /**
     * set coach
     * @param coach
     */
    public void setCoach(String coach)
    {
        if (coach.length() > 2 && coach.length() < 26)
        {
            this.coach = coach;
        }
        else
        {
            throw new IllegalArgumentException("Coach name must be between 3-25 characters.");
        }
    }

    /**
     * get points
     * @return
     */
    public int getPoints()
    {
        return points;
    }

    /**
     * set points
     * @param points
     */
    public void setPoints(int points)
    {
        if (points >= 0)
        {
            this.points = points;
        }
        else
        {
            throw new IllegalArgumentException("Points must not be a negative number.");
        }
    }

    /**
     * get wins
     * @return
     */
    public int getWins()
    {
        return wins;
    }

    /**
     * set wins
     * @param wins
     */
    public void setWins(int wins)
    {
        if (wins >= 0 && wins <= 100)
        {
            this.wins = wins;
        }
        else
        {
            throw new IllegalArgumentException("Wins must be between 0-100.");
        }
    }

    /**
     * get losses
     * @return
     */
    public int getLosses()
    {
        return losses;
    }

    /**
     * set losses
     * @param losses
     */
    public void setLosses(int losses)
    {
        if (losses >= 0 && losses <= 100)
        {
            this.losses = losses;
        }
        else
        {
            throw new IllegalArgumentException("Losses must be between 0-100.");
        }
    }

    /**
     * get ties
     * @return
     */
    public int getTies()
    {
        return ties;
    }

    /**
     * set ties
     * @param ties
     */
    public void setTies(int ties)
    {
        if (ties >= 0 && ties <= 100)
        {
            this.ties = ties;
        }
        else
        {
            throw new IllegalArgumentException("Ties must be between 0-100.");
        }
    }

    /**
     * get league id
     * @return
     */
    public int getLeagueId()
    {
        return leagueId;
    }

    /**
     * set league id
     * @param leagueId
     */
    public void setLeagueId(int leagueId)
    {
        if (leagueId >= 0)
        {
            this.leagueId = leagueId;
        }
        else
        {
            throw new IllegalArgumentException("League ID must not be a negative number.");
        }
    }

    /**
     * get string of team for standings. Includes team name and points
     * @return
     */
    public String toString()
    {
        return team + " - " + points + "pts";
    }

}
