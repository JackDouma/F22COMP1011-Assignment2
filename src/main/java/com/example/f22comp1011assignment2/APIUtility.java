package com.example.f22comp1011assignment2;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

public class APIUtility
{
    /**
     * This method calls the azure api
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public static Team[] getTeamsFromAzure() throws IOException, InterruptedException
    {
        // connection string
        String uri = "https://sportpal.azurewebsites.net/api/Standings";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        HttpResponse<Path> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofFile(Paths.get("jsonData.json")));

        Gson gson = new Gson();
        return getTeamsFromJson();
    }

    /**
     * This method reads the json file, and returns it as a teams array
     * @return
     */
    public static Team[] getTeamsFromJson()
    {
        Gson gson = new Gson();
        Team[] teams = null;

        try
                (
                        FileReader fileReader = new FileReader("jsonData.json");
                        JsonReader jsonReader = new JsonReader(fileReader);
                )
        {
            teams = gson.fromJson(jsonReader, Team[].class);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return teams;
    }

    /**
     * returns info of a single team using id provided
     * @param id
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public static Team getTeamInfo(int id) throws IOException, InterruptedException {
        String uri = "https://sportpal.azurewebsites.net/api/Standings/" + id;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();
        HttpResponse<String> response = client.send(httpRequest,
                HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        return gson.fromJson(response.body(), Team.class);
    }
}
