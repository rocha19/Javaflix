package com.learn.javaflix.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Movie {
  protected int id;
  protected int externalId;
  protected String posterPath;
  protected String title;
  protected String overview;
  protected String releaseDate;
}




