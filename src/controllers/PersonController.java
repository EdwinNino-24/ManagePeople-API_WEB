package controllers;

import com.google.gson.Gson;
import models.Family;
import models.Person;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Edwin Niño
 */

public class PersonController {
    
    private final String endpoint;

    public PersonController() {
        this.endpoint = "https://619fb1c61ac52a0017ba4a02.mockapi.io/person";
    }

    public void createPerson(String json) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .headers("Content-Type", "application/json")
                .timeout(Duration.of(10, ChronoUnit.SECONDS))
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void createFamilyPerson(int personId, String json) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint + "/" + personId + "/family"))
                .headers("Content-Type", "application/json")
                .timeout(Duration.of(10, ChronoUnit.SECONDS))
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void updatePerson(int id, String json) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint + "/" + id))
                .headers("Content-Type", "application/json")
                .timeout(Duration.of(10, ChronoUnit.SECONDS))
                .PUT(HttpRequest.BodyPublishers.ofString(json))
                .build();

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void updateFamilyPerson(int personId, String json, int id) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint + "/" + personId + "/family/" + id))
                .headers("Content-Type", "application/json")
                .timeout(Duration.of(10, ChronoUnit.SECONDS))
                .PUT(HttpRequest.BodyPublishers.ofString(json))
                .build();

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void getPeople() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .headers("Content-Type", "application/json")
                .timeout(Duration.of(10, ChronoUnit.SECONDS))
                .GET()
                .build();

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        }
        catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void getPerson(int id) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint + "/" + id))
                .headers("Content-Type", "application/json")
                .timeout(Duration.of(10, ChronoUnit.SECONDS))
                .GET()
                .build();

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void getFamilyPerson(int id) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint + "/" + id + "/family"))
                .headers("Content-Type", "application/json")
                .timeout(Duration.of(10, ChronoUnit.SECONDS))
                .GET()
                .build();

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void deletePerson(int id) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint + "/" + id))
                .headers("Content-Type", "application/json")
                .timeout(Duration.of(10, ChronoUnit.SECONDS))
                .DELETE()
                .build();

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void deleteFamilyPerson(int personId, int id) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint + "/" + personId + "/family/" + id))
                .headers("Content-Type", "application/json")
                .timeout(Duration.of(10, ChronoUnit.SECONDS))
                .DELETE()
                .build();

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    public String personToJson(Person person) {
        Gson gson = new Gson();
        return gson.toJson(person);
    }

    public Person jsonToPerson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Person.class);
    }


    public String familyToJson(Family family) {
        Gson gson = new Gson();
        return gson.toJson(family);
    }

    public Family jsonToFamily(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Family.class);
    }

}
