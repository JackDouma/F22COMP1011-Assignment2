package com.example.f22comp1011assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class TeamViewController
{

    @FXML
    private Label coachLabel;

    @FXML
    private Label leagueLabel;

    @FXML
    private Label lossesLabel;

    @FXML
    private Label pointsLabel;

    @FXML
    private Label teamLabel;

    @FXML
    private Label tiesLabel;

    @FXML
    private Button viewStandingsButton;

    @FXML
    private Label winsLabel;

    /**
     * SceneChanger calls this method when scene is changed to team view
     * @param standingId
     * @throws IOException
     * @throws InterruptedException
     */
    public void getTeamDetails(int standingId) throws IOException, InterruptedException
    {
        // get team data
        Team team = APIUtility.getTeamDetails(standingId);

        // fill labels
        teamLabel.setText(team.getTeam());
        coachLabel.setText(team.getCoach());
        pointsLabel.setText(String.valueOf(team.getPoints()));
        winsLabel.setText(String.valueOf(team.getWins()));
        lossesLabel.setText(String.valueOf(team.getLosses()));
        tiesLabel.setText(String.valueOf(team.getTies()));

        // set league depending on the ID. Will make this automated if I have time
        if (team.getLeagueId() == 1)
        {
            leagueLabel.setText("Varsity Football 2022");
        }
        else if (team.getLeagueId() == 2)
        {
            leagueLabel.setText("Super Curlers International");
        }
        else if (team.getLeagueId() == 3)
        {
            leagueLabel.setText("Ice Slicing Super League");
        }
    }

    @FXML
    private void getStandings(ActionEvent event) throws IOException, InterruptedException
    {
        SceneChanger.changeScenes(event,"standings-view.fxml");
    }

}