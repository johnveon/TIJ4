package typeinfo;

//: typeinfo/HiddenImplementation.java
// Sneaking around package access.
import typeinfo.interfacea.*;
import typeinfo.packageaccess.*;
import java.lang.reflect.*;

public class HiddenImplementation {
  public static void main(String[] args) throws Exception {
    A a = HiddenC.makeA();
    a.f();
    System.out.println(a.getClass().getName());
    // Compile error: cannot find symbol 'C':
    /* if(a instanceof C) {//不能访问C，因为C是包访问类型的，出了这个包typeinfo.packageaccess就没权限访问
      C c = (C)a;//这样就可以限制，通过a向下转型成C，调用g()
      c.g();
    } */
    // Oops! Reflection still allows us to call g()://但是，用反射仍然能调用g()：
    callHiddenMethod(a, "g");
    // And even methods that are less accessible!
    callHiddenMethod(a, "u");
    callHiddenMethod(a, "v");
    callHiddenMethod(a, "w");
  }
  static void callHiddenMethod(Object a, String methodName)
  throws Exception {
    Method g = a.getClass().getDeclaredMethod(methodName);//根据名字拿到定义的方法
    g.setAccessible(true);//设置它能被访问，即使原来没有访问权限
    g.invoke(a);//还可以传参数
  }
} /* Output:
public C.f()
typeinfo.packageaccess.C
public C.g()
package C.u()
protected C.v()
private C.w()
*///:~
