package com.learn.javaflix.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.javaflix.utils.database.SqLite;

@RestController
@RequestMapping("/api")
public class GetAllMovies {

  @GetMapping("/movies")
  public String getMovies() {
    SqLite.handle();
    return "movies";
  }
}
