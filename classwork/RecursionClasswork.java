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
    if (target == 0) {
      return true;
    }
    if (start == nums.length) {
      return false;
    } else {
      if (nums[start] == 6) {
       return groupSum6(start+1, nums, target - nums[start]);
      }
      return groupSum6(start+1, nums, target) ||
      groupSum6(start+1, nums, target - nums[start]);
    }
  }





  public static void main(String[] args) {
    // int[] arr1 = {2,4,8};
    // System.out.println(groupSum(0,arr1,10));
    // System.out.println(groupSum(0,arr1,14));
    // System.out.println(groupSum(0,arr1,9));
    // System.out.println(groupSum(0,arr1,4));

    int[] arr2 = {2,2};
    int[] arr3 = {2,3};
    int[] arr4 = {5,2,3};
    System.out.println(splitArray(arr2));
    System.out.println(splitArray(arr3));
    System.out.println(splitArray(arr4));




  }
}
