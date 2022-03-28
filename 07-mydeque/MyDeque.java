import java.util.*;

public class MyDeque<E>{
  private E[] data;
  private int size;
  private int start, end;

  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
  }

  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
  }

  public int size(){

  }

  public String toString(){

  }

  public void addFirst(E element) throws NullPointerException{

  }

  public void addLast(E element) throws NullPointerException{

  }

  public E removeFirst() throws NoSuchElementException{

  }

  public E removeLast() throws NoSuchElementException{

  }

  public E getFirst() throws NoSuchElementException{

  }

  public E getLast() throws NoSuchElementException{

  }
}
