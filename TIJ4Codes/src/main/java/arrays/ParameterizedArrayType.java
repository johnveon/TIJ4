package arrays;

//: arrays/ParameterizedArrayType.java

class ClassParameter<T> {//Peel<Banana> peels = new Peel<Banana>[10] 一般情况，不能实例化具有参数化类型的数组
  public T[] f(T[] arg) { return arg; }//但是你可以参数数组本身的类型
}

class MethodParameter {
  public static <T> T[] f(T[] arg) { return arg; }
}

public class ParameterizedArrayType {
  public static void main(String[] args) {
    Integer[] ints = { 1, 2, 3, 4, 5 };
    Double[] doubles = { 1.1, 2.2, 3.3, 4.4, 5.5 };
    Integer[] ints2 =
      new ClassParameter<Integer>().f(ints);
    Double[] doubles2 =
      new ClassParameter<Double>().f(doubles);
    ints2 = MethodParameter.f(ints);//参数化方法比参数化类更方便，少写类型，首选
    doubles2 = MethodParameter.f(doubles);
  }
} ///:~
