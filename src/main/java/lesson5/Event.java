package lesson5;

public class Event {
  private int id;
  private String name;
  private String city;

  public Event(int id, String name, String city) {
    this.id = id;
    this.name = name;
    this.city = city;
  }

  @Override
  public String toString() {
    return "Event{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", city='" + city + '\'' +
        '}';
  }
}
