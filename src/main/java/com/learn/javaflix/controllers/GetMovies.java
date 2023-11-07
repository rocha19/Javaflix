package com.learn.javaflix.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GetMovies {
  @GetMapping("/movie/{id}")
  public String getMoviesById(@PathVariable String id) {
    return "movies: " + id;
  }

  @GetMapping("/movie")
  public String getMoviesByIdByQuery(@RequestParam String id) {
    return "movies: " + id;
  }
}
