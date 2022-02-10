public class RecursionClasswork{
  // Group Sum
  public static boolean groupSum(int start, int[] nums, int target) {
    if (target == 0) {
      return true;
    }
    if (start == nums.length) {
      return false;
    } else {
      return groupSum(start+1, nums, target) ||
      groupSum(start+1, nums, target - nums[start]);
    }
  }

  //splitArray
  public static boolean splitArray(int[] nums) {
    return splitArray(0, nums, 0, 0);
  }
  public static boolean splitArray(int start, int[] nums, int sum1, int sum2) {
    if (start == nums.length) {
      if (sum1 == sum2) {
        return true;
      }
      return false;
    } else {
      return splitArray(start+1, nums, sum1 + nums[start], sum2) ||
      splitArray(start+1, nums, sum1, sum2 + nums[start]);
    }
  }

  public static boolean groupSum6(int start, int[] nums, int target) {
    if (start == nums.length) {
      return (target == 0);
    } else {
      if (nums[start] == 6) {
       return groupSum6(start+1, nums, target - nums[start]);
      }
      return groupSum6(start+1, nums, target) ||
      groupSum6(start+1, nums, target - nums[start]);
    }
  }

  public static boolean groupNoAdj(int start, int[] nums, int target) {
    if (start >= nums.length) {  // > symbol since we are increasing start by 2 in some cases, which can be over the length
      return (target == 0);
    } else {
      return groupNoAdj(start+1, nums, target) ||
      groupNoAdj(start+2, nums, target - nums[start]);
    }
  }

  public static boolean splitOdd10(int[] nums) {
    return splitOdd10(0, nums, 0, 0);
  }

  public static boolean splitOdd10(int start, int[] nums, int sum1, int sum2) {
    if (start == nums.length) {
      if (((sum1 % 2 == 1) && (sum2 % 10 == 0)) || ((sum2 % 2 == 1) && (sum1 % 10 == 0))) {
        return true;
      }
      return false;
    } else {
      return splitOdd10(start+1, nums, sum1 + nums[start], sum2) ||
      splitOdd10(start+1, nums, sum1, sum2 + nums[start]);
    }
  }




  public static void main(String[] args) {
    // int[] arr1 = {2,4,8};
    // System.out.println(groupSum(0,arr1,10));
    // System.out.println(groupSum(0,arr1,14));
    // System.out.println(groupSum(0,arr1,9));
    // System.out.println(groupSum(0,arr1,4));
    //
    // int[] arr2 = {2,2};
    // int[] arr3 = {2,3};
    // int[] arr4 = {5,2,3};
    // System.out.println(splitArray(arr2));
    // System.out.println(splitArray(arr3));
    // System.out.println(splitArray(arr4));
    //
    // int[] arr5 = {5,6,2};
    // System.out.println(groupSum6(0,arr5,8));
    // System.out.println(groupSum6(0,arr5,9));
    // System.out.println(groupSum6(0,arr5,7));
    //
    // int[] arr6 = {2,5,10,4};
    // System.out.println(groupNoAdj(0,arr6,12));
    // System.out.println(groupNoAdj(0,arr6,14));
    // System.out.println(groupNoAdj(0,arr6,7));

    int[] arr7 = {5, 5, 5};
    int[] arr8 = {5, 5, 6};
    int[] arr9 = {5, 5, 6, 1};
    System.out.println(splitOdd10(arr7));
    System.out.println(splitOdd10(arr8));
    System.out.println(splitOdd10(arr9));








  }
}
