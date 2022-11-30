package com.example.f22comp1011assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneChanger
{
    /**
     * change scene to team view
     * @param event
     * @param fxmlFile
     * @param standingId
     * @throws IOException
     * @throws InterruptedException
     */
    public static void changeScenes(ActionEvent event, String fxmlFile, int standingId) throws IOException, InterruptedException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load());

        // get controller
        TeamViewController controller = fxmlLoader.getController();
        controller.getTeamDetails(standingId);

        // get stage
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    /**
     * change scenes to standings view
     * @param event
     * @param fxmlFile
     * @throws IOException
     * @throws InterruptedException
     */
    public static void changeScenes(ActionEvent event, String fxmlFile) throws IOException, InterruptedException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load());

        // get stage
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }
}
