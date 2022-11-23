package com.example.f22comp1011assignment2;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIUtility
{
    /**
     * This method calls the azure api
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public static APIResponse getTeamsFromAzure() throws IOException, InterruptedException
    {
        String uri = "temp";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        return gson.fromJson(response.body(), APIResponse.class);
    }

    /**
     * This method reads the json file
     * @return
     */
    public static APIResponse getTeamsFromJson()
    {
        Gson gson = new Gson();
        APIResponse apiResponse = null;

        try
        (
            FileReader fileReader = new FileReader("jsonData.json");
            JsonReader jsonReader = new JsonReader(fileReader);
        )
        {
            apiResponse = gson.fromJson(jsonReader, APIResponse.class);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return apiResponse;
    }
}
