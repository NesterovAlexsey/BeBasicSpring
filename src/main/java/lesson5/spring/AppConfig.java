package lesson5.spring;

import javax.sql.DataSource;
import lesson5.UserDAO;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
  public DataSource dataSource() {
      PGSimpleDataSource pgDataSource = new PGSimpleDataSource();
      pgDataSource.setServerName("localhost");
      pgDataSource.setDatabaseName("cohort24");
      pgDataSource.setUser("postgres");
      pgDataSource.setPassword("1111");
      return pgDataSource;
    }

    @Bean
  public UserDAO userDAO() {
      return  new UserDAO(dataSource());
    }
}
