package generics;

//: generics/LinkedStack.java
// A stack implemented with an internal linked structure.

public class LinkedStack<T> {//类泛型：初始化的时候可以指定T，以确保这个初始化的对象只处理T或者继承T的类型
  private static class Node<U> {
    U item;
    Node<U> next;
    Node() { item = null; next = null; }
    Node(U item, Node<U> next) {
      this.item = item;
      this.next = next;//指向之前的top节点
    }
    boolean end() { return item == null && next == null; }
  }
  private Node<T> top = new Node<T>(); // End sentinel //用户无参数构造函数，初始top节点，空的
  public void push(T item) {
    top = new Node<T>(item, top);//用户有参数构造函数，每次push都new出来的当前节点就是top节点
  }	
  public T pop() {
    T result = top.item;
    if(!top.end())
      top = top.next;//把top节点弹出，现在的top节点为前一个节点
    return result;
  }
  public static void main(String[] args) {
    LinkedStack<String> lss = new LinkedStack<String>();
    for(String s : "Phasers on stun!".split(" "))
      lss.push(s);
    String s;
    while((s = lss.pop()) != null)
      System.out.println(s);
  }
} /* Output:
stun!
on
Phasers
*///:~
