package com.learn.javaflix.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import com.learn.javaflix.repositories.contracts.UserRepositoryContract;
import org.springframework.stereotype.Repository;
import com.learn.javaflix.libs.SqLite;
import com.learn.javaflix.models.User;

@Repository
public class UserRespository implements UserRepositoryContract 
{
  private SqLite sqlite;

  public UserRespository(SqLite sqlite) 
  {
    this.sqlite = sqlite;
  }

  @Override
  public Optional<User> findByUsername(String username) 
  {
    String sql = "SELECT * FROM movie WHERE username = ?";
    try (Connection connection = sqlite.connect();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

      preparedStatement.setString(1, username);
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        if (resultSet.next()) {
          return Optional.of(new User(
              resultSet.getString("username"), 
              resultSet.getString("password")
              ));
        }
      }
    } catch (SQLException e) 
    {
      e.printStackTrace();
    }
    return Optional.empty();
  }
  
  @Override
  public boolean save(String username, String password) 
  {
    try (Connection connection = sqlite.connect();
         PreparedStatement checkStmt = connection.prepareStatement("SELECT * FROM movie WHERE username = ?");
        PreparedStatement insertStmt = connection
            .prepareStatement("INSERT INTO movie (username, password) VALUES (?, ?)")) 
         {

      checkStmt.setString(1, username);

      try (ResultSet resultSet = checkStmt.executeQuery()) 
      {
        if (resultSet.next()) {
          return false;
        }
      }

      insertStmt.setString(1, username);
      insertStmt.setString(2, password);

      insertStmt.executeUpdate();
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }
}
