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

  /*mergesortH is the actual mergesort method.
  *@data the array to be sorted
  *@return a new array that is the sorted version of data.
  */
  public static int[] mergesortH(int [] data){
    if (data.length <= 1) {
      return data;
    }
    int length = data.length;
    int middle = length/2;
    int[] left = new int[middle];
    int[] right;
    if (length % 2 == 0) {
      right = new int[middle];
    } else {
      right = new int[middle+1];
    }

    for (int i = 0; i < left.length; i++) {
      left[i] = data[i];
    }
    for (int j = 0; j < right.length; j++) {
      right[j] = data[j+middle];
    }
    left = mergesortH(left);
    right = mergesortH(right);
    data = merge(left, right);
    return data;
  }

  /*mergesort uses the recursive mergesortH method to create a sorted
  *version of the array. It then copies the data back into the original
  *array. (This is for compatibility with prior sort testers)
  *@param data the array to be sorted, this will be modified by the method
  */
  public static void mergesort(int [] data){
    int [] temp  =  mergesortH(data);
    for(int i = 0; i < data.length; i++){
      data[i] = temp[i];
    }
  }



  public static void main(String[] args) {
    int[] test = {1,5,6,8};
    int[] test2 = {5,10,24};
    int[] arr = {1, 6, 2, 3, 8, 10, 9, 100, 78, 0, -5, -123, 56, 123};
    int[] sorted = {1,2,3,4,5,6,7,8,9,10,11,122};
    int[] revSorted = {122,11,10,9,8,7,6,5,4,3,2,1,-10};
    System.out.println(Arrays.toString(merge(test, test2)));
    mergesort(arr);
    mergesort(sorted);
    mergesort(revSorted);
    System.out.println(Arrays.toString(arr));
    System.out.println(Arrays.toString(sorted));
    System.out.println(Arrays.toString(revSorted));
  }
}
