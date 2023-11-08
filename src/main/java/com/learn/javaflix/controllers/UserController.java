package com.learn.javaflix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.javaflix.models.User;
import com.learn.javaflix.service.AuthUserService;
import com.learn.javaflix.service.RegisterUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController 
{

  @Autowired
  private AuthUserService authUsersService;

  @Autowired
  private RegisterUserService registerUserService;

  @PostMapping("/login")
  public ResponseEntity<Object> login(@RequestBody User user) 
  {
    try 
    {
      var response = this.authUsersService.perform(user);
      return ResponseEntity.ok().body(response);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }
  }

  @PostMapping("/register")
  public ResponseEntity<Object> register(@Valid @RequestBody User user) 
  {
    try 
    {
      var response = this.registerUserService.perform(user);

      if (!response) 
      {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
      }

      return ResponseEntity.status(HttpStatus.CREATED).body("");
    } catch (Exception e) 
    {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }
}
