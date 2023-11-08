package com.learn.javaflix.repositories.contracts;

import java.util.List;
import java.util.Optional;

import com.learn.javaflix.models.Movie;

public interface MovieRepositoryContract {
  List<Movie> findAll();
  Optional<Movie> findById(int id);
  boolean save(int externalId, int useiId);
  boolean  updateById(int id, String username);
  boolean  deleteById(int id);
}
