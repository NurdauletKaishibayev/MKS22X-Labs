/**********
Merge Sort
**********/
import java.util.Arrays;

public class Merge {

  public static int[] merge(int [] left, int[] right){
    int leftLen = left.length;
    int rightLen = right.length;
    int[] data = new int[leftLen + rightLen];
    int i = 0;
    int j = 0;
    int k = 0;
    while ( i < leftLen && j < rightLen) {
      if (left[i] < right[j]) {
        data[k] = left[i];
        k++;
        i++;
      } else {
        data[k] = right[j];
        k++;
        j++;
      }
    }

    while (i < leftLen) {
      data[k] = left[i];
      k++;
      i++;
    }

    while (j < rightLen) {
      data[k] = right[j];
      k++;
      j++;
    }
    return data;
  }

  // public static void mergesort(data){
  //   int [] temp  =  mergeSortH(data);
  //   copy temp into data
  // }
  //
  // public static int[] mergesortH(data){
  //   if more than 1 element{
  //     left = copy half of data
  //     right = copy other half of data
  //     return merge(mergesortH(left),mergesortH(right))
  //   }
  // }

  public static void main(String[] args) {
    int[] test = {1,5,6,8};
    int[] test2 = {5,10,24};
    System.out.println(Arrays.toString(merge(test, test2)));
  }
}
