package com.learn.javaflix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.javaflix.models.Movie;
import com.learn.javaflix.repositories.MovieRepository;
import com.learn.javaflix.service.ApiRequest;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class GetMovies {
  @Autowired
  private MovieRepository movieRepository;

  @Autowired
  private ApiRequest apiRequest;

  @GetMapping("/movies")
  public ResponseEntity<List<Movie>> getAllMovies() {
    List<Movie> movies = movieRepository.findAll();
    apiRequest.perform(0);
    return ResponseEntity.ok(movies);
  }

  @GetMapping("/movie/{id}")
  public ResponseEntity<Movie> getMovieById(@PathVariable int id) {
    apiRequest.perform(id);
    Optional<Movie> movie = movieRepository.findById(id);
    return movie
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }
}
