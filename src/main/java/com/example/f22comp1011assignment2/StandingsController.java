package com.example.f22comp1011assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class StandingsController implements Initializable
{

    @FXML
    private ComboBox<String> changeLeagueComboBox;

    @FXML
    private ListView<Team> listView;

    @FXML
    private Button viewTeamButton;

    /**
     * This method runs when view is called
     * @param url
     * @param resourceBundle
     */
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
        changeLeagueComboBox.getItems().addAll("All Leagues", "Varsity Football 2022", "Super Curlers International", "Ice Slicing Super League");

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

        // listener for combo box
        changeLeagueComboBox.getSelectionModel().selectedItemProperty().addListener((obs,old,league)->{
            // clear listview
            listView.getItems().clear();
            int selectedLeague = 0;

            // get selected league value depending on what user selected
            if (league.equals("Varsity Football 2022"))
            {
                selectedLeague = 1;
            }
            else if (league.equals("Super Curlers International"))
            {
                selectedLeague = 2;
            }
            else if (league.equals("Ice Slicing Super League"))
            {
                selectedLeague = 3;
            }
            else
            {
                selectedLeague = 0;
            }

            // populate listview
            try
            {
                Team[] teams = APIUtility.getTeamsFromAzure();

                // if specific league is selected
                if (selectedLeague != 0)
                {
                    for (Team team : teams)
                    {
                        if (team.getLeagueId() == selectedLeague)
                        {
                            listView.getItems().add(team);
                        }
                    }
                }
                // if user selects all leagues
                else
                {
                    listView.getItems().addAll(teams);
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
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

