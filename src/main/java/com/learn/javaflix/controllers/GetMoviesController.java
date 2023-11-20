package com.learn.javaflix.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.javaflix.models.Movie;
import com.learn.javaflix.repositories.MovieRepository;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api")
public class GetMoviesController {
  @Autowired
  private MovieRepository movieRepository;

  @GetMapping("/movies")
  public ResponseEntity<List<Movie>> getAllMovies() {
    List<Movie> movies = movieRepository.findAll();
    return ResponseEntity.ok(movies);
  }

  @GetMapping("/movie/{id}")
  public ResponseEntity<Movie> getMovieById(@PathVariable int id) {
    Optional<Movie> movie = movieRepository.findById(id);
    return movie
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }
}
