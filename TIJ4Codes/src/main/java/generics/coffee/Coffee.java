//: generics/coffee/Coffee.java
package generics.coffee;

public class Coffee {
  private static long counter = 0;//静态成员变量（属性）
  private final long id = counter++;//一分配就不可变的成员变量（属性）
  public String toString() {
    return getClass().getSimpleName() + " " + id;
  }
} ///:~
