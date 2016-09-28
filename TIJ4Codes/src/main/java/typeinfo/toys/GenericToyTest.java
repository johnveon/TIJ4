//: typeinfo/toys/GenericToyTest.java
// Testing class Class.
package typeinfo.toys;

public class GenericToyTest {
  public static void main(String[] args) throws Exception {
    Class<FancyToy> ftClass = FancyToy.class;
    // Produces exact type:
    FancyToy fancyToy = ftClass.newInstance();//声明为Class<FancyToy> ，可以用FancyToy fancyToy接住，当然也可以用Object fancyToy接住
    Class<? super FancyToy> up = ftClass.getSuperclass();//? super FancyToy FancyToy的父类，虽然知道Toy是它的父类
    // This won't compile:
    // Class<Toy> up2 = ftClass.getSuperclass();//虽然知道Toy是它的父类，也不能这样
    // Only produces Object:
    Object obj = up.newInstance();//只能用Object接住他的实例，虽然知道Toy是它的父类：声明为模糊类型Class<? super FancyToy>，只能用模糊的 Object obj接住
    // This won't compile:
    //Toy obj = up.newInstance();//不能指定确切的类型Toy
  }
} ///:~
