package lesson5;

/*

Create table:
    CREATE TABLE users (
    id      	SERIAL PRIMARY KEY,
    name    	TEXT NOT NULL,
    password  TEXT NOT NULL
  );

added request:
INSERT INTO users (name, password) VALUES ('Aleksey', '*****'), ('Viktors', '***'), ('Vadim', '*');

Check all Table data:
SELECT * FROM user

 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.postgresql.ds.PGSimpleDataSource;

public class UserDAO {

  private DataSource dataSource;

  public UserDAO(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public User findById(Integer id) throws SQLException {
    //settings connection with dataBase

    User user = null;

    try (Connection connection = dataSource.getConnection()) {
      PreparedStatement ps = connection
          .prepareStatement("select * from users where id = ?");
      // 1 - number of ? meta symbol
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        user = new User(rs.getInt(1),
            rs.getString(2),
            rs.getString(3));
      }
    }

    return user;
  }

  public User findByName(String name) throws SQLException {
    //settings connection with dataBase

    User user = null;

    try (Connection connection = dataSource.getConnection()) {
      PreparedStatement ps = connection
          .prepareStatement("select * from users where name = ?");
      // 1 - number of ? meta symbol
      ps.setString(1, name);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        user = new User(rs.getInt(1),
            rs.getString(2),
            rs.getString(3));
      }
    }
    return user;
  }
}
