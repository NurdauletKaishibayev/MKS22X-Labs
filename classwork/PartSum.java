public class PartSum{
  public static boolean partialSum(int[] arr, int targetValue) {
    return partialSum(0, arr, targetValue);
  }

  public static boolean partialSum(int start, int[] arr, int targetValue) {
    if (start == arr.length - 1) {
      return false;
    } else {
      if (arr[start] + arr[start + 1] == targetValue) {
        return 
      } else {
        return partialSum(start+1, arr, targetValue);
      }
    }
  }

  public static void main(String[] args) {
    int[] arr1 = {2,4,8};
    System.out.println(partialSum(arr1,10));
  }
}
