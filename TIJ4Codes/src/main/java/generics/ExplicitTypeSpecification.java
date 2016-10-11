package generics;

//: generics/ExplicitTypeSpecification.java
import typeinfo.pets.*;
import java.util.*;
import net.mindview.util.*;

public class ExplicitTypeSpecification {//怎么样才能f(New.map())?
  static void f(Map<Person, List<Pet>> petPeople) {}
  public static void main(String[] args) {
    f(New.<Person, List<Pet>>map());//显示指定类型：类名+.+<类型,类型>+方法名()
  }
} ///:~
