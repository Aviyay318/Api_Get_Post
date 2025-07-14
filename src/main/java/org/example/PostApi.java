package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PostApi {
    //httpClient - שליח
    //HttpRequest - המכתב , הבקשה
    //HttpResponse - התשובה שחוזרת , התגובה
    //ObjectMapper - ממירים אובייקט לג'ייסון

    static HttpClient httpClient = HttpClient.newHttpClient();
    public static void main(String[] args) throws IOException, InterruptedException {
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("enter your name: ");
//        String name = scanner.nextLine();
//        System.out.println("enter your email: ");
//        String email = scanner.nextLine();
//
//        Map<String, String> data = new HashMap<>();
//        data.put("name",name);
//        data.put("email", email);

        Student student = new Student("121","abc",99,true);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(student); //הופכים את המידע שלנו לJSON


        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
                .header("Content-Type","application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response = httpClient.send(request,HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());

    }

}
