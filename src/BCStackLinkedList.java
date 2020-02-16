public class BCStackLinkedList<T> implements BCStack<T>{


  // create a Node called top and an int called size
  Node top;
  int size;

  // here's the node class
  class Node {
    T item;
    Node next;
  }


  // constructor
  public BCStackLinkedList() {
    this.top = null;
    this.size = 0;
  }

  // push
  public void push(T s) {
    Node newnode = new Node();
    newnode.item = s;
    newnode.next = top;
    top = newnode;
    size++;
  }

  // peek: easy, but check if empty!
  public T peek() {
    if (isEmpty()) {
      System.out.println("Stack is empty!");
      return null;
    }
    return top.item;
  }

  // pop: like peek but you need to decrement size!
  public T pop() {
    if (this.isEmpty()) {
      System.out.println("The stack is empty.");
      return null;
    }
    T returnme = this.top.item;
    this.top = this.top.next;
    this.size--;
    return returnme;
  }

  // isEmpty()
  public boolean isEmpty() {
    return (this.size == 0);
  }

  // print out from the top of the stack
  public String toString() {
    StringBuilder sb = new StringBuilder();
    Node n = top;
    while (n != null) {
      sb.append(n.item);
      n = n.next;
    }
    return sb.toString();
  }

  public static void main (String[] args) {
    BCStack<String> ss = new BCStackLinkedList<String>();
    ss.push("dog");
    ss.push("cat");
    ss.push("gerbil");
    ss.push("parrot");
    ss.push("pony");
    System.out.println(ss.toString());
    System.out.println("Popping off " + ss.pop());
    System.out.println(ss.toString());
    System.out.println("Popping off " + ss.pop());
    System.out.println("Popping off " + ss.pop());
    System.out.println("Popping off " + ss.pop());
    System.out.println("Popping off " + ss.pop());
    System.out.println("Popping off " + ss.pop());
    System.out.println("Popping off " + ss.pop());
    System.out.println(ss.toString());
    ss.push("apple");
    ss.push("orange");
    System.out.println(ss.toString());

    // But we can also have a stack of Doubles!
    BCStack<Double> ds = new BCStackLinkedList<Double>();
    ds.push(4.2);
    ds.push(702097.);
    System.out.println(ds.toString());
    System.out.println(ds.peek());
    System.out.println(ds.pop());
    System.out.println(ds.pop());
    System.out.println(ds.pop());


  }

}
