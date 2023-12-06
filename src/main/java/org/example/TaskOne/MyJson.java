package org.example.TaskOne;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;

public class MyJson {

    HttpClient client = HttpClient.newHttpClient();

    public String createUser(String jsonUserFilePath) throws IOException, InterruptedException {
        String uri = "https://jsonplaceholder.typicode.com/users";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json; charset=UTF-8")
                .POST(HttpRequest.BodyPublishers.ofFile(Paths.get(jsonUserFilePath)))
                .build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String updateUserById(int userId, String jsonUserFilePath) throws IOException, InterruptedException {
        String uri = "https://jsonplaceholder.typicode.com/users/" + userId;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json; charset=UTF-8")
                .PUT(HttpRequest.BodyPublishers.ofFile(Paths.get(jsonUserFilePath)))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public int deleteUserById(int id) throws IOException, InterruptedException {
        String uri = "https://jsonplaceholder.typicode.com/users/" + id;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .DELETE()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.statusCode();
    }

    public String getAllUsers() throws IOException, InterruptedException {
        String uri = "https://jsonplaceholder.typicode.com/users";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String getUserById(int id) throws IOException, InterruptedException {
        String uri = "https://jsonplaceholder.typicode.com/users/" + id;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String getUserByName(String userName) throws IOException, InterruptedException {
        String uri = "https://jsonplaceholder.typicode.com/users?username=" + userName;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public void createJsonWithUser(String jsonUser, String jsonFilePath) {
        UserJPH user = createUserFromJson(jsonUser);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String outputString = gson.toJson(user);
        try (FileWriter output = new FileWriter(jsonFilePath)) {
            output.write(outputString);
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public void createJsonWithUsers(String jsonUsers, String jsonFilePath) {
        UserJPH[] users = createUsersFromJson(jsonUsers);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String outputString = gson.toJson(users);
        try (FileWriter output = new FileWriter(jsonFilePath)) {
            output.write(outputString);
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public UserJPH createUserFromJson(String json) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.fromJson(json, UserJPH.class);
    }

    public UserJPH[] createUsersFromJson(String json) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.fromJson(json, UserJPH[].class);
    }

    static class UserJPH {
        private final int id;
        private final String name;
        private final String username;
        private final String email;
        private final Object address;
        private final String phone;
        private final String website;
        private final Object company;

        public UserJPH(int id, String name, String username, String email, Object address, String phone, String website, Object company) {
            this.id = id;
            this.name = name;
            this.username = username;
            this.email = email;
            this.address = address;
            this.phone = phone;
            this.website = website;
            this.company = company;
        }

        @Override
        public String toString() {
            return "UserJPH{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", username='" + username + '\'' +
                    ", email=" + email +
                    ", address=" + address +
                    ", phone='" + phone + '\'' +
                    ", website='" + website + '\'' +
                    ", company=" + company +
                    '}';
        }
    }

}
