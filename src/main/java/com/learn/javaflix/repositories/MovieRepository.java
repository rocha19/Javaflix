package com.learn.javaflix.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.learn.javaflix.libs.SqLite;
import com.learn.javaflix.models.FeatureFilm;
import com.learn.javaflix.models.Movie;
import com.learn.javaflix.repositories.contracts.MovieRepositoryContract;

@Repository
public class MovieRepository implements MovieRepositoryContract 
{
  private SqLite sqlite;

  public MovieRepository(SqLite sqlite) {
    this.sqlite = sqlite;
  }

  @Override
  public List<Movie> findAll() {
    List<Movie> movies = new ArrayList<>();
    String sql = "SELECT * FROM movie";
    try (Connection connection = sqlite.connect();
         PreparedStatement preparedStatement = connection.prepareStatement(sql);
         ResultSet resultSet = preparedStatement.executeQuery()) {
      
      while (resultSet.next()) {
        movies.add(new FeatureFilm(
            resultSet.getInt("id"),
            resultSet.getInt("externalId"),
            resultSet.getString("access_token")
      ));
    }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return movies;
  }
  
  @Override
  public Optional<Movie> findById(int id) {
    String sql = "SELECT * FROM movie WHERE externalId = (?)";
    try (Connection connection = sqlite.connect();
         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      
      preparedStatement.setInt(1, id);
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        if (resultSet.next()) {
          return Optional.of(new FeatureFilm(
            resultSet.getInt("id"),
            resultSet.getInt("externalId"),
            resultSet.getString("access_token")
          ));
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return Optional.empty();
  }

  @Override 
  public boolean save(int externalId, int userId) {
    try (Connection connection = sqlite.connect();
         PreparedStatement checkStatement = connection.prepareStatement("SELECT * FROM movie WHERE externalId = (?) AND userId = (?)");
         PreparedStatement insertStmt = connection.prepareStatement("INSERT INTO movie (externalId) VALUES (?) WHERE userId = (?)")) {

      checkStatement.setInt(1, userId);
      checkStatement.setInt(2, externalId);

      try (ResultSet resultSet = checkStatement.executeQuery()) {
        if (resultSet.next()) {
          return false;
        }
      }

      insertStmt.setInt(1, externalId);
      insertStmt.setInt(2, userId);

      insertStmt.executeUpdate();
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public boolean updateById(int id, String newUsername) {
    String sql = "UPDATE movie SET username = ? WHERE id = ?";
    try (Connection connection = sqlite.connect();
         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      
      preparedStatement.setString(1, newUsername);
      preparedStatement.setInt(2, id);
      int affectedRows = preparedStatement.executeUpdate();

      return affectedRows > 0;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public boolean deleteById(int id) {
    String sql = "DELETE FROM movie WHERE id = ?";
    try (Connection connection = sqlite.connect();
         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      
      preparedStatement.setInt(1, id);
      int affectedRows = preparedStatement.executeUpdate();

      return affectedRows > 0;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }
}
