import java.util.*;

public class MyDeque<E>{
  private E[] data;
  private int size;
  private int start, end;

  public MyDeque(){
    // Calls the bottom constructor which creates a size 10 array
    this(10);
  }

  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    start = data.length/2;
    end = data.length/2;
    size = 0;
  }

  // call when start = length
  private void resize() {

  }

  public int size(){
    return size;
  }

  // toString that prints values from start to end in ORDER
  public String toString(){
    String out = "[";
    if (end < start) {
      for (int i = start; i < data.length; i++) {
        out += data[i] + ", ";
      }
      for (int j = 0; j <= end; j++) {
        if (j == end) {
          out += data[j] + "]";
        } else {
          out += data[j] + ", ";
        }
      }
      return out;
    } else {
      for (int i = start; i <= end; i++) {
        if (i == end) {
          out += data[i] + "]";
        } else {
          out += data[i] + ", ";
        }
      }
      return out;
    }
  }


  // Prints out the entire array with all nulls and etc.
  public String toStringDebug() {
    String out = "[";
    for (int i = 0; i < data.length; i++) {
      if (i == data.length-1) {
        if (data[i] == null) {
          out += "null]";
        } else {
          out += data[i] + "]";
        }
      } else {
        if (data[i] == null) {
          out += "null, ";
        } else {
          out += data[i] + "]";
        }
      }
    }
    return out;
  }

  public void addFirst(E element) throws NullPointerException{

  }

  public void addLast(E element) throws NullPointerException{

  }

  // public E removeFirst() {
  //   if (size == 0) {
  //     throw new NoSuchElementException();
  //   }
  //
  // }
  //
  // public E removeLast() {
  //   if (size == 0) {
  //     throw new NoSuchElementException();
  //   }
  // }

  public E getFirst() {
    if (size == 0) {
      throw new NoSuchElementException();
    }
    return data[start];
  }

  public E getLast() {
    if (size == 0) {
      throw new NoSuchElementException();
    }
    return data[end];
  }

  public static void main(String[] args) {
    MyDeque<Integer> deque = new MyDeque<Integer>();
    System.out.println(deque);
    System.out.println(deque.toStringDebug());
  }
}
