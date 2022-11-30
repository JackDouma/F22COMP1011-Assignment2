package com.example.f22comp1011assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class StandingsController implements Initializable
{

    @FXML
    private ComboBox<String> changeLeagueComboBox;

    @FXML
    private ListView<Team> listView;

    @FXML
    private Button viewTeamButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        // make visibility of view team button false until team is selected
        viewTeamButton.setVisible(false);

        // populate listview
        try
        {
            Team[] teams = APIUtility.getTeamsFromAzure();

            listView.getItems().addAll(teams);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        // populate league -> will make it automated if I have time
        changeLeagueComboBox.getItems().addAll("Varsity Football 2022", "Super Curlers International", "Ice Slicing Super League");

        // listener for the list view. When team is selected, this code will run
        listView.getSelectionModel().selectedItemProperty().addListener((obs, old, selectedTeam)->{
            // if team is selected
            if (selectedTeam != null)
            {
                // make visibility of view team button true
                viewTeamButton.setVisible(true);
            }
            else
            {
                // make visibility of view team button false
                viewTeamButton.setVisible(false);
            }
        });
    }

    /**
     * when view team button is pressed, change scenes
     * @param event
     * @throws IOException
     * @throws InterruptedException
     */
    @FXML
    private void getTeamDetails(ActionEvent event) throws IOException, InterruptedException
    {
        Team team = listView.getSelectionModel().getSelectedItem();
        SceneChanger.changeScenes(event,"team-view.fxml",team.getStandingId());
    }
}

