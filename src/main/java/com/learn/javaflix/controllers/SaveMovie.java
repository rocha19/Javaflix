package com.learn.javaflix.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.javaflix.libs.SqLite;
import com.learn.javaflix.repositories.MovieRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class SaveMovie {
  @Autowired
  private SqLite sqlite;

  @PostMapping("/save")
  public ResponseEntity<Object> handle(@Valid @RequestHeader Map<String, String> headers, @RequestBody Movie movie) {
    if (movie.externalId() == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Empty field: Add a movie id!");
    }

    MovieRepository movieRepository = new MovieRepository(sqlite);
    boolean response = movieRepository.save(movie.externalId(), movie.userId());

    if (!response) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Movie already exists!");
    }
    
    return ResponseEntity.status(HttpStatus.CREATED).body("");
  }
  
  record Movie(Integer externalId, Integer userId) {}
}
