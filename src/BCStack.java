interface BCStack<T> {
  void push(T s);
  T pop();
  T peek();
  boolean isEmpty();
  String toString();
}
