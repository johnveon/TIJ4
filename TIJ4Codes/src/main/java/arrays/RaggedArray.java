package arrays;

//: arrays/RaggedArray.java
import java.util.*;

public class RaggedArray {
  public static void main(String[] args) {
    Random rand = new Random(47);
    // 3-D array with varied-length vectors:
    int[][][] a = new int[rand.nextInt(7)][][];//初始化时，至少一定要指定数组的长度，第一维，其他维可以不用指定
    for(int i = 0; i < a.length; i++) {
      a[i] = new int[rand.nextInt(5)][];//同上注释
      for(int j = 0; j < a[i].length; j++)
        a[i][j] = new int[rand.nextInt(5)];
    }
    System.out.println(Arrays.deepToString(a));
    
    int[] empty = new int[0];//数组的长度可以是0
    System.out.println(empty.length);
    //!empty[0]=1;//但是不能赋值了
  }
} /* Output:
[[], [[0], [0], [0, 0, 0, 0]], [[], [0, 0], [0, 0]], [[0, 0, 0], [0], [0, 0, 0, 0]], [[0, 0, 0], [0, 0, 0], [0], []], [[0], [], [0]]]
*///:~
