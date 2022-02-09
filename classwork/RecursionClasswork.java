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

  public static void main(String[] args) {
    int[] arr1 = {2,4,8};

    System.out.println(groupSum(0,arr1,10));
    System.out.println(groupSum(0,arr1,14));
    System.out.println(groupSum(0,arr1,9));
    System.out.println(groupSum(0,arr1,4));
  }
}
