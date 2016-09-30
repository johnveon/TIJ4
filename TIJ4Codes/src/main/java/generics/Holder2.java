package generics;

//: generics/Holder2.java

public class Holder2 {
  private Object a;
  public Holder2(Object a) { this.a = a; }
  public void set(Object a) { this.a = a; }
  public Object get() { return a; }
  public static void main(String[] args) {
    Holder2 h2 = new Holder2(new Automobile());//可以存储多种类型的对象Automobile
    Automobile a = (Automobile)h2.get();
    h2.set("Not an Automobile");//可以存储多种类型的对象String
    String s = (String)h2.get();
    h2.set(1); // Autoboxes to Integer //可以存储多种类型的对象Integer
    Integer x = (Integer)h2.get();
  }
} ///:~
