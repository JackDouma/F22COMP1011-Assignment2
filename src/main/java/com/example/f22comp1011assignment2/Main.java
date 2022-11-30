package com.example.f22comp1011assignment2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("standings-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("SportPal");

        // from https://www.demo2s.com/java/javafx-stage-geticons.html
        stage.getIcons().add(new Image(this.getClass().getResource("sportpal.png").toString()));

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException, InterruptedException
    {
        launch();
    }
}