package generics;

//: generics/ErasedTypeEquivalence.java
import java.util.*;

public class ErasedTypeEquivalence {
  public static void main(String[] args) {
    Class c1 = new ArrayList<String>().getClass();
    Class c2 = new ArrayList<Integer>().getClass();
    System.out.println(c1 == c2);//ArrayList<String>和ArrayList<Integer>类型居然是相等的，这就是擦除
  }
} /* Output:
true
*///:~
