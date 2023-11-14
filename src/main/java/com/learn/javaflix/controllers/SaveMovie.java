package com.learn.javaflix.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.javaflix.libs.SqLite;
import com.learn.javaflix.models.Movie;
import com.learn.javaflix.repositories.MovieRepository;

@RestController
@CrossOrigin(maxAge = 3600, allowCredentials = "true")
@RequestMapping("/api")
public class SaveMovie {
  @Autowired
  private SqLite sqlite;

  @CrossOrigin
  @PostMapping("/save")
  public ResponseEntity<Object> handle(Map<String, String> headers, @RequestBody Movie movie) {
    if (movie.getExternalId() < 1) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Empty field: Add a movie id!");
    }

    MovieRepository movieRepository = new MovieRepository(sqlite);
    boolean response = movieRepository.save(movie);

    if (!response) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Movie already exists!");
    }
    
    return ResponseEntity.status(HttpStatus.CREATED).body("");
  }
  
  // record Movie(int id, int externalId, String posterPath, String title, String overview, String releaseDate) {}
}
