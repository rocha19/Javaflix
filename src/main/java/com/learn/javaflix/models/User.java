package com.learn.javaflix.models;

import lombok.Data;

@Data
public class User {
  protected int id;
  protected String username;
  protected String password;
  protected String accessToken;

  public User(String username, String password, String accessToken) {
    this.username = username;
    this.password = password;
    this.accessToken = accessToken;
  }
}
