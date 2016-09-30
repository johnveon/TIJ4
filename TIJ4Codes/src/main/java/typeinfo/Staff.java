package typeinfo;

//: typeinfo/Staff.java
import java.util.*;

public class Staff extends ArrayList<Position> {
  public void add(String title, Person person) {
    add(new Position(title, person));
  }
  public void add(String... titles) {
    for(String title : titles)
      add(new Position(title));//初始化岗位的时候，对应的人都默认Person.NULL
  }
  public Staff(String... titles) { add(titles); }
  public boolean positionAvailable(String title) {
    for(Position position : this)//本身就是list
      if(position.getTitle().equals(title) &&
         position.getPerson() == Person.NULL)//这个岗位对应是不是还没有人了
        return true;
    return false;
  }	
  public void fillPosition(String title, Person hire) {
    for(Position position : this)//本身就是list
      if(position.getTitle().equals(title) &&
         position.getPerson() == Person.NULL) {
        position.setPerson(hire);
        return;
      }
    throw new RuntimeException(
      "Position " + title + " not available");
  }	
  public static void main(String[] args) {
    Staff staff = new Staff("President", "CTO",
      "Marketing Manager", "Product Manager",
      "Project Lead", "Software Engineer",
      "Software Engineer", "Software Engineer",
      "Software Engineer", "Test Engineer",
      "Technical Writer");
    staff.fillPosition("President",
      new Person("Me", "Last", "The Top, Lonely At"));
    staff.fillPosition("Project Lead",
      new Person("Janet", "Planner", "The Burbs"));
    if(staff.positionAvailable("Software Engineer"))
      staff.fillPosition("Software Engineer",
        new Person("Bob", "Coder", "Bright Light City"));
    System.out.println(staff);
  }
} /* Output:	
[Position: President Person: Me Last The Top, Lonely At, Position: CTO NullPerson, Position: Marketing Manager NullPerson, Position: Product Manager NullPerson, Position: Project Lead Person: Janet Planner The Burbs, Position: Software Engineer Person: Bob Coder Bright Light City, Position: Software Engineer NullPerson, Position: Software Engineer NullPerson, Position: Software Engineer NullPerson, Position: Test Engineer NullPerson, Position: Technical Writer NullPerson]
*///:~
