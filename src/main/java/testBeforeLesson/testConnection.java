package testBeforeLesson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class testConnection {

  private static Connection connection;

  public static void main(String[] args) {
    try {
      connect();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      disconnect();
    }
  }

  static void connect() throws SQLException {
    connection =
        DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
            "postgres",
            "1111");
  }

  static void disconnect() {
    try {
      if (connection != null) {
        connection.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}

