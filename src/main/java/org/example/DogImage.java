package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DogImage {
 public String message;

    @Override
    public String toString() {
        return "DogImage{" +
                "message='" + message + '\'' +
                '}';
    }
}
