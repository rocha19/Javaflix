package com.learn.javaflix.repositories.contracts;

import java.util.Optional;
import com.learn.javaflix.models.User;

public interface UserRepositoryContract {
  Optional<User> findByUsername(String username);
  boolean save(String username, String password);
}
