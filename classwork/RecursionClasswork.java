public class RecursionClasswork{
  // Group Sum
  public static boolean groupSum(int start, int[] nums, int target) {
    if (target == 0) {
      return true;
    }
    if (start == nums.length - 1) {
      return false;
    } else {
      if (nums[start+1] > target) {
        return groupSum(start + 1, nums, target);
      } else {
        return groupSum(start+1, nums, target) ||
        groupSum(start+1, nums, target - nums[start+1]);
      }
    }
  }

  public static void main(String[] args) {
    int[] arr1 = {2,4,8};
    System.out.println(groupSum(0,arr1,10));
  }
}
