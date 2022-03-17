import java.util.*;
public class Quick {
  /*Modify the array such that:
  *1. A random index from start to end inclusive is chosen, the
  * corresponding element is designated the pivot element.
  *2. all elements in range that are smaller than the pivot element
  * are placed before the pivot element.
  *3. all elements in range that are larger than the pivot element are
  *placed after the pivot element.
  *4. Only the indices from start to end inclusive are considered in range
  *@return the index of the final position of the pivot element.
  */

  public static int partition ( int [] data, int start, int end){
    int randomIndex = (int)(Math.random()*(end-start+1) + start);
    int pivot = data[randomIndex];
    int index = start;
    int index2 = end;
    int val = data[index];
    data[index] = pivot;
    data[randomIndex] = val;
    randomIndex = index;
    index++;
    int counter = 0;

    // System.out.println(index);
    // System.out.println(index2);
    // System.out.println(pivot);
    // System.out.println(randomIndex);
    for (int i = start; i < end; i++) {
      if (counter % 2 == 0) {
        if (data[index] < pivot) {
          int temp = data[index];
          data[index] = pivot;
          data[randomIndex] = temp;
          index++;
          randomIndex++;
        }
        else {
          int temp = data[index];
          data[index] = data[index2];
          data[index2] = temp;
          index2--;
        }
        counter++;
      } else {
        if (data[index] <= pivot) {
          int temp = data[index];
          data[index] = pivot;
          data[randomIndex] = temp;
          index++;
          randomIndex++;
        }
        else {
          int temp = data[index];
          data[index] = data[index2];
          data[index2] = temp;
          index2--;
        }
        counter++;
      }

    }
    return index-1;
  }

  /*return the value that is the kth smallest value of the array.
  *@param data must have a length > 0
  *@param k is 0 to data.length-1 inclusive
  *@postcondition The array may be modified. */
  public static int quickselect(int[]data, int k){
    int start = 0;
    int end = data.length-1;
    while (true) {
      int p = partition(data, start, end);
      if (k > p) {
        start = p+1;
      }
      if (k < p) {
        end = p-1;
      }
      if (k == p) {
        return data[k];
      }
    }
  }

  /* Quicksort method is wrapper*/
  public static void quicksort(int[]data){
    quicksort(data,0,data.length-1);
  }

  public static void quicksort(int[]data,int lo,int hi){
    if (lo < hi) {
      int p = partition(data, lo, hi);
      quicksort(data, lo, p-1);
      quicksort(data, p+1, hi);
    }
  }

  public static void main(String[] args) {
    // int[] arr = {999,999,999,4,3,2,1,0,999,999,999};
    // System.out.println(partition(arr, 3,7));
    // String out = "";
    // for (int a = 0; a < arr.length; a++) {
    //   out += arr[a] + ", ";
    // }
    // System.out.println(out);
    int[] ary = {2, 10, 15, 23, 0, 5};
    int[] ary3 = {1,6,5,6,7,9,6,3,8,6};
    // System.out.println(Arrays.toString(ary));
    //sorted(ary): {0, 2, 5, 10, 15, 23}
    //This is to show what the returned value would be in all cases.
    //DO NOT run all of these at once!
    // System.out.println(quickselect(ary3 ,4)); //would return 15
    // System.out.println(Arrays.toString(ary));
    quicksort(ary);
    System.out.println(Arrays.toString(ary));
    quicksort(ary3);
    System.out.println(Arrays.toString(ary3));
  }
}
