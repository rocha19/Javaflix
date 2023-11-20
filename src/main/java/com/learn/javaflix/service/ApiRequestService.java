package com.learn.javaflix.service;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ApiRequestService {

    @Value("${my.custom.property}")
    private String apiKey;

    public CompletableFuture<String> perform(int id) {
        HttpClient client = HttpClient.newHttpClient();
        String uriString;

        if (id == 0) {
            uriString = "https://api.themoviedb.org/3/movie/popular?api_key=" + apiKey + "&language=pt-BR&page=1";
        } else {
            uriString = "https://api.themoviedb.org/3/movie/" + id + "/popular?api_key=" + apiKey + "&language=pt-BR&page=1";
        }

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(uriString))
            .build();

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                     .thenApply(HttpResponse::body);
    }
}
