package lesson5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

public class EventDAO {

  private DataSource dataSource;

  public EventDAO(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public Event findById(int id) throws SQLException {
    Event event = null;

    try (Connection connection = dataSource.getConnection()) {
      PreparedStatement ps = connection.prepareStatement("select * from events where id = ?");
      ps.setInt(1, id);
      //объект ResultSet - представляет результат выполнения запроса
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        event = new Event(rs.getInt(1),
            rs.getString(2),
            rs.getString(3));
      }
    }

    return event;
  }

  public Event findByName(String name) throws SQLException {
    Event event = null;

    try (Connection connection = dataSource.getConnection()) {
      PreparedStatement ps =
          connection.prepareStatement("select * from events where name = ?");
      ps.setString(1, name);
      ResultSet rs = ps.executeQuery();

        if (rs.next()) {
          event = new Event(
              rs.getInt(1),
              rs.getString(2),
              rs.getString(3)
          );
        }
    }
    return event;
  }
}
