package generics;

//: generics/LimitsOfInference.java
import typeinfo.pets.*;
import java.util.*;

public class LimitsOfInference {
  static void
  f(Map<Person, List<? extends Pet>> petPeople) {}
  public static void main(String[] args) {//类型推断只对赋值操作（=）有效，其他时候无效，比如：将New.map()作为参数
     //f(New.map()); // Does not compile
  }
} ///:~
