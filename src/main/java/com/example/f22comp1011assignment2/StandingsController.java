package com.example.f22comp1011assignment2;

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
        try {
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
    }
}

