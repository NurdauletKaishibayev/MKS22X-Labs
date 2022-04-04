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
    @SuppressWarnings("unchecked")
    E[] newArr = (E[])new Object[data.length * 2 + 1];  // Make array length of double that of data (+1 for the 0 length case)
    if (start == 0) {
      int count = 0;
      for (int i = start; i < data.length; i++) {
        newArr[count] = data[i];
        count++;
      }
      end = count;


    } else {


      int count = 0;
      for (int i = start; i < data.length; i++) {
        newArr[count] = data[i];
        count++;
      }

      for (int j = 0; j < end; j++) {
        newArr[count] = data[j];
        count++;
      }
      start = 0;
      end = count;
    }

    // else {
    //   int count = 0;
    //   for (int i = start; i < end; i++) {
    //     newArr[count] = newArr[i];
    //     count++;
    //   }
    //   start = 0;
    //   end = count-1;
    // }

    data = newArr;
  }

  public int size(){
    return size;
  }

  // toString that prints values from start to end in ORDER
  public String toString(){
     if (size() == 0) {
       return "[]";
     }

     if (start == 0 && end == 0) {
       String out = "[";
       for (int i = start; i < data.length; i++) {
         if (i == data.length-1) {
           out += data[i];
         } else {
           out += data[i] + ", ";
         }
       }
       return out+"]";
     }

       String out = "[";
       if (end < start) {
         for (int i = start; i < data.length; i++) {
           if (end == 0) {
             if (i == data.length-1) {
               out += data[i];
               break;
             } else {
               out += data[i] + ", ";
             }
           } else {
             out += data[i] + ", ";
           }


         }
         for (int j = 0; j < end; j++) {
           if (j == end-1) {
             out += data[j];
           } else {
             out += data[j] + ", ";
           }
         }
         return out + "]";





    } else if (start == end) {
      for (int i = start; i < data.length; i++) {
        out += data[i] + ", ";
      }
      for (int j = 0; j < end; j++) {
        if (j == end-1) {
          out += data[j];
        } else {
          out += data[j] + ", ";
        }
      }
      return out + "]";

    } else {
      for (int i = start; i < end; i++) {
        if (i == end-1) {
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

    if (start == 0) {
      start = data.length-1;
      data[start] = element;
      size++;
    } else {
      start--;
      data[start] = element;
      size++;
    }
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
      data[end] = element;
      end = 0;
      size++;
    } else {
      data[end] = element;
      size++;
      end++;
    }
  }

  public E removeFirst() {
    if (size() == 0) {
      throw new NoSuchElementException("Array is Empty!");
    }
    E elm = getFirst();
    if (start == data.length-1) {
      data[start] = null;
      start = 0;
      size--;
      return elm;
    }
    data[start] = null;
    start++;
    size--;
    return elm;
  }

  public E removeLast() {
    if (size() == 0) {
      throw new NoSuchElementException("Array is Empty!");
    }
    E elm = getLast();
    if (end == 0) {
      end = data.length-1;
      data[end] = null;
      size--;
      return elm;
    } else {
      data[end-1] = null;
      end--;
      size--;
      return elm;
    }
  }

  public E getFirst() {
    if (size() == 0) {
      throw new NoSuchElementException("Array is Empty!");
    }
    return data[start];
  }

  public E getLast() {
    if (size() == 0) {
      throw new NoSuchElementException("Array is Empty!");
    }
    if (end == 0) {
      return data[data.length-1];
    } else {
      return data[end-1];
    }
  }

  // public void start() {
  //   System.out.println(start);
  // }
  //
  // public void end() {
  //   System.out.println(end);
  // }

  // public static void main(String[] args) {
  //   MyDeque<Integer> deque = new MyDeque<Integer>();
  //
  //
  //   System.out.println("First: " + deque.getFirst());
  //   System.out.println("Last: " + deque.getLast());
  //   System.out.println("Size: " + deque.size());
  //   // System.out.println(deque);
  //   // System.out.println(deque.toStringDebug());
  //
  //   System.out.println("-=-=-=-= START =-=-=-=-");
  //   deque.start();
  //   System.out.println("-=-=-=-= END =-=-=-=-");
  //   deque.end();
  // }
}
