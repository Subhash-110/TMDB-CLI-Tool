package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Main {

    private static final String API_KEY = "YOUR_API_KEY";
    private static final String BASE_URL = "https://api.themoviedb.org/3/movie/";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose movie type:");
        System.out.println("playing | popular | top | upcoming");
        System.out.print("Enter type: ");

        String type = scanner.nextLine();
        String endpoint;

        switch (type) {
            case "playing":
                endpoint = "now_playing";
                break;
            case "popular":
                endpoint = "popular";
                break;
            case "top":
                endpoint = "top_rated";
                break;
            case "upcoming":
                endpoint = "upcoming";
                break;
            default:
                System.out.println("Invalid type.");
                return;
        }

        fetchMovies(endpoint);
    }

    private static void fetchMovies(String endpoint) {

        String url = BASE_URL + endpoint + "?api_key=" + API_KEY;

        try {

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {

                JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
                JsonArray movies = jsonObject.getAsJsonArray("results");

                System.out.println("\nMovies:\n");

                for (int i = 0; i < movies.size(); i++) {
                    JsonObject movie = movies.get(i).getAsJsonObject();
                    String title = movie.get("title").getAsString();
                    System.out.println((i + 1) + ". " + title);
                }

            } else {
                System.out.println("API Error: " + response.statusCode());
            }

        } catch (Exception e) {
            System.out.println("Network Error: " + e.getMessage());
        }
    }
}