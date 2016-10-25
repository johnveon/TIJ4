package arrays;

//: arrays/ArrayOfGenerics.java
// It is possible to create arrays of generics.
import java.util.*;

public class ArrayOfGenerics {
  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
    List<String>[] ls;//不允许实例参数化类型的数组，允许声明参数化类型的数组的引用
    List[] la = new List[10];//允许实例化非泛型（非参数化类型）数组
    ls = (List<String>[])la; // "Unchecked" warning//然后转型成参数化类型的数组
    ls[0] = new ArrayList<String>();
    // Compile-time checking produces an error:
    //! ls[1] = new ArrayList<Integer>();//从而得到编译器的检查

    // The problem: List<String> is a subtype of Object
    Object[] objects = ls; // So assignment is OK//数组是协变类型的，所以可以这样
    // Compiles and runs without complaint:
    objects[1] = new ArrayList<Integer>();

    // However, if your needs are straightforward it is
    // possible to create an array of generics, albeit
    // with an "unchecked" warning:
    List<BerylliumSphere>[] spheres =
      (List<BerylliumSphere>[])new List[10];//这样就可以创建一个泛型数组了，确保这个数组只能持有BerylliumSphere类型的list
    for(int i = 0; i < spheres.length; i++)
      spheres[i] = new ArrayList<BerylliumSphere>();
  }
} ///:~
