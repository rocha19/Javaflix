package com.learn.javaflix.models;

import lombok.Data;

@Data
public class User {
  protected int id;
  protected String username;
  protected String password;

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }
}
