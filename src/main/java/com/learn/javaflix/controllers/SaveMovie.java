package com.learn.javaflix.controllers;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class SaveMovie {

  @PostMapping("/save")
  public ResponseEntity<Object> handle(@Valid @RequestHeader Map<String, String> headers, @RequestBody Movie movie) {
    if (movie.exeternalId() == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Empty movie, add a movie id!");
    }
    return ResponseEntity.status(HttpStatus.CREATED).body("success!!!");
  }
  
  record Movie(Integer exeternalId) {}
}
