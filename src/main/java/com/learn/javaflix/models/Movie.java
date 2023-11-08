package com.learn.javaflix.models;

import lombok.Data;

@Data
public abstract class Movie {
  protected int externalId;
  protected int useId;
  protected String accessToken;

  public Movie(int externalId, int useId, String accessToken) {
    this.externalId = externalId;
    this.useId = useId;
    this.accessToken = accessToken;
  }
}




