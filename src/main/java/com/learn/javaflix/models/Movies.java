package com.learn.javaflix.models;

// import org.hibernate.validator.constraints.Length;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
// @Entity(name = "movie")
public class Movies {

  // @Id
  // @GeneratedValue(strategy = GenerationType.UUID)
  private int id;

  // @NotBlank
  // @Length(min = 1, max = 4, message = "The id of the movie is required!")
  int externalId;
}
