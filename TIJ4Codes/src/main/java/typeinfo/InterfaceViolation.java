package typeinfo;

//: typeinfo/InterfaceViolation.java
// Sneaking around an interface.
import typeinfo.interfacea.*;

class B implements A {
  public void f() {}
  public void g() {System.out.println("B.g()");}
}

public class InterfaceViolation {
  public static void main(String[] args) {
    A a = new B();
    a.f();
    // a.g(); // Compile error 编译不通过，不代表就没办法调用B中的g()
    System.out.println(a.getClass().getName());
    if(a instanceof B) {//变量a是B或者B的继承的类型吗
      B b = (B)a;
      b.g();//通过A调用到了B中的g()
    }
  }
} /* Output:
B
*///:~
