package lesson5.spring;

import java.sql.SQLException;
import lesson5.Event;
import lesson5.EventDAO;
import lesson5.User;
import lesson5.UserDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserDaoSpringDemo {

  public static void main(String[] args) throws SQLException {
    ApplicationContext context =
        new AnnotationConfigApplicationContext(AppConfig.class);

//    UserDAO userDAO = context.getBean(UserDAO.class);
//    for (int i = 1; i < 4; i++) {
//      User user = userDAO.findById(i);
//      System.out.println(user);
//    }

    EventDAO eventDAO = context.getBean(EventDAO.class);
    for (int i = 1; i < 3; i++) {
      Event event = eventDAO.findById(i);
      System.out.println(event);
    }

    Event eventByName = eventDAO.findByName("Concert");
    System.out.println("Task 2. Find by name: " + eventByName);
  }
}
