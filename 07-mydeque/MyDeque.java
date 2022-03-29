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
    start = 0;
    end = 0;
    size = 0;
  }

  // call when size = length of the array
  private void resize() {
    data = Arrays.copyOf(data, (data.length * 2)+1 );
  }

  public int size(){
    return size;
  }

  // toString that prints values from start to end in ORDER
  public String toString(){
    String out = "[";
    if (end < start) {
      for (int i = start+1; i < data.length; i++) {
        out += data[i] + ", ";
      }
      for (int j = 0; j <= end; j++) {
        if (j == end) {
          out += data[j];
        } else {
          out += data[j] + ", ";
        }
      }
      return out + "]";
    } else {
      for (int i = start+1; i <= end; i++) {
        if (i == end) {
          out += data[i];
        } else {
          out += data[i] + ", ";
        }
      }
      return out + "]";
    }
  }


  // Prints out the entire array with all nulls and etc.
  public String toStringDebug() {
    String out = "[";
    for (int i = 0; i < data.length; i++) {
      if (i == data.length-1) {
        if (data[i] == null) {
          out += "null";
        } else {
          out += data[i];
        }
      } else {
        if (data[i] == null) {
          out += "null, ";
        } else {
          out += data[i] + ", ";
        }
      }
    }
    return out + "]";
  }


  public void addFirst(E element) {
    if (element == null) {
      throw new NullPointerException("Cannot add null!");
    }

    if (size() == 0) {
      start = data.length/2;
      end = data.length/2;
    }

    if (size() == data.length) {
      resize();
    }
    data[start] = element;
    size++;
    start--;
  }

  public void addLast(E element) {
    if (element == null) {
      throw new NullPointerException("Cannot add null!");
    }

    if (size() == 0) {
      start = data.length/2;
      end = data.length/2;
    }

    if (size() == data.length) {
      resize();
    }

    if (end == data.length-1) {
      end = 0;
      data[end] = element;
      size++;
    } else {
      data[end+1] = element;
      size++;
      end++;
    }
  }

  // public E removeFirst() {
  //   if (size == 0) {
  //     throw new NoSuchElementException("Array is Empty!");
  //   }
  //
  // }
  //
  // public E removeLast() {
  //   if (size == 0) {
  //     throw new NoSuchElementException("Array is Empty!");
  //   }
  // }

  public E getFirst() {
    if (size() == 0) {
      throw new NoSuchElementException("Array is Empty!");
    }
    return data[start+1];
  }

  public E getLast() {
    if (size() == 0) {
      throw new NoSuchElementException("Array is Empty!");
    }
    return data[end];
  }

  public static void main(String[] args) {
    MyDeque<Integer> deque = new MyDeque<Integer>();
    deque.addFirst(2);
    deque.addFirst(3);
    deque.addFirst(4);
    deque.addFirst(5);
    deque.addLast(10);
    deque.addLast(11);
    deque.addLast(12);
    deque.addLast(13);
    deque.addLast(14);
    deque.addFirst(15);

    System.out.println(deque.getFirst());
    System.out.println(deque.getLast());
    System.out.println(deque.size());
    System.out.println(deque);
    System.out.println(deque.toStringDebug());
  }
}
