package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MyApi {
    public static final int PROGRAMMING = 1;
    public static final int DARK= 2;
    public static final int ANY = 3;

    //any
    //Programming
    //Misc
    //Dark
    //Pun
    //Spooky
    //Christmas

    //httpClient - שליח
    //HttpRequest - המכתב , הבקשה
    //HttpResponse - התשובה שחוזרת , התגובה
    //ObjectMapper - להמיר ממחרוזת לג'ייסון (אובייקט)
    static HttpClient httpClient = HttpClient.newHttpClient(); //לשלוח את הבקשה

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("choose category" + "\n" + "1) Programming"
        +"\n" +"2) Dark" + "\n" +"3) Any");
        int categoryId = scanner.nextInt();
        String category = getMyCategory(categoryId);
        String result = getJokeByUrl("https://v2.jokeapi.dev/joke/" + category);
        int indexOf = result.indexOf("category");
        ObjectMapper mapper = new ObjectMapper();
        Joke joke = mapper.readValue(result, Joke.class);
        System.out.println(joke);
    }

    private static String getMyCategory(int categoryId) {
        return switch (categoryId){
            case PROGRAMMING -> "Programming";
            case DARK -> "Dark";
            default -> "any";
        };
    }


    private static String getJokeByUrl(String url) throws IOException, InterruptedException {
        //תיצור לנו את הבקשה , נשלח את הבקשה ונתפוס את מה שהיא מחזירה
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

       HttpResponse<String> response = httpClient.send(
               request,
               HttpResponse.BodyHandlers.ofString()
       );
      return response.body();
    }
}
