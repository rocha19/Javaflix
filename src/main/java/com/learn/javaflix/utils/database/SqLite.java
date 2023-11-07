package com.learn.javaflix.utils.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqLite
{
  public static void handle()
  {
    Connection connection = null;
    try
    {
      // create a database connection
      connection = DriverManager.getConnection("jdbc:sqlite:javaflix.db");
      Statement statement = connection.createStatement();
      statement.setQueryTimeout(30);  // set timeout to 30 sec.

      // statement.executeUpdate("drop table if exists movie");
      statement.executeUpdate("create table movie (id integer, externalId integer)");
      // statement.executeUpdate("insert into movie values(1, 123)");
      // statement.executeUpdate("insert into movie values(2, 321)");
      ResultSet rs = statement.executeQuery("select * from movie");
      while(rs.next())
      {
        // read the result set
        System.out.println("id = " + rs.getInt("id"));
        System.out.println("externalId = " + rs.getString("externalId"));
      }
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
