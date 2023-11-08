package com.learn.javaflix.libs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;

@Component
public class SqLite
{
  public Connection connect() throws SQLException {
    // create a database connection and return it
    return DriverManager.getConnection("jdbc:sqlite:javaflix.db");
  }
  
  public void handle()
  {
    Connection connection = null;
    try
    {
      // create a database connection
      connection = DriverManager.getConnection("jdbc:sqlite:javaflix.db");
      Statement statement = connection.createStatement();
      statement.setQueryTimeout(30);  // set timeout to 30 sec.

      // statement.executeUpdate("drop table if exists movie");
      statement.executeUpdate("CREATE TABLE movie (id INTEGER PRIMARY KEY AUTOINCREMENT, externalId INTEGER UNIQUE, username VARCHAR(20) UNIQUE, password VARCHAR(20) UNIQUE, access_token VARCHAR(20) UNIQUE NULL)");
    }
    catch(SQLException e)
    {
      // if the error message is "out of memory",
      // it probably means no database file is found
      System.err.println(e.getMessage());
    }
    finally
    {
      try
      {
        if(connection != null)
          connection.close();
      }
      catch(SQLException e)
      {
        // connection close failed.
        System.err.println(e.getMessage());
      }
    }
  }
}
