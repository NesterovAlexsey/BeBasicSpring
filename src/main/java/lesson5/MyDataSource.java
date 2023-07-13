package lesson5;

import javax.sql.DataSource;
import org.postgresql.ds.PGSimpleDataSource;

public class MyDataSource {
  private static DataSource dataSource;

  public static DataSource getDataSource() {
    if (dataSource == null) {
      // настройка соединения с базой данных
      PGSimpleDataSource pgDataSource = new PGSimpleDataSource();
      pgDataSource.setServerName("localhost");
      pgDataSource.setDatabaseName("cohort24");
      pgDataSource.setUser("postgres");
      pgDataSource.setPassword("1111");
      dataSource = pgDataSource;
    }
    return dataSource;
  }
}


