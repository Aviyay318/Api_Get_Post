package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DogImageApi {
    static HttpClient httpClient = HttpClient.newHttpClient();
    public static void main(String[] args) throws IOException, InterruptedException {
        String url = "https://dog.ceo/api/breeds/image/random";
        String result = fetchDogImage(url);
        ObjectMapper mapper = new ObjectMapper();
        DogImage image = mapper.readValue(result,DogImage.class);
        System.out.println(image);

        BufferedImage bufferedImage = ImageIO.read(new URL(image.message));
        File myImage = new File("src/main/resources/Dog.png");
        ImageIO.write(bufferedImage,"png",myImage);

        System.out.println(myImage.getAbsolutePath());
    }

    private static String fetchDogImage(String url) throws IOException, InterruptedException {
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
