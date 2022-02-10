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


  // groupSum6
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


  // groupNoAdj
  public static boolean groupNoAdj(int start, int[] nums, int target) {
    if (start >= nums.length) {  // > symbol since we are increasing start by 2 in some cases, which can be over the length
      return (target == 0);
    } else {
      return groupNoAdj(start+1, nums, target) ||
      groupNoAdj(start+2, nums, target - nums[start]);
    }
  }


  // splitOdd10
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


  // split53
  public static boolean split53(int[] nums) {
    return split53(0, nums, 0, 0);
  }

  public static boolean split53(int start, int[] nums, int sum1, int sum2) {
    if (start == nums.length) {
      if (sum1 == sum2) {
        return true;
      }
      return false;
    } else {
      if (nums[start] % 3 == 0) {
        return split53(start+1, nums, sum1, sum2 + nums[start]);
      }
      if (nums[start] % 5 == 0) {
        return split53(start+1, nums, sum1 + nums[start], sum2);
      }
      return split53(start+1, nums, sum1 + nums[start], sum2) ||
      split53(start+1, nums, sum1, sum2 + nums[start]);
    }
  }


  // groupSum5
  public static boolean groupSum5(int start, int[] nums, int target) {
    if (start >= nums.length) {
      return (target == 0);
    } else {
      if (nums[start] % 5 == 0) {
        if ((start<nums.length-1) && nums[start+1] == 1) {
          return groupSum5(start+2, nums, target - nums[start]);
        }
       return groupSum5(start+1, nums, target - nums[start]);
      }
      return groupSum5(start+1, nums, target) ||
      groupSum5(start+1, nums, target - nums[start]);
    }
  }

  // groupSumClump

  public static boolean groupSumClump(int start, int[] nums, int target) {
    if (start >= nums.length) {
      return (target == 0);
    } else {
      if (start < nums.length-1 && nums[start] == nums[start+1]) {
        int counter = 1;
        for (int i = start; i < nums.length-1; i++) {
          if (nums[i] == nums[i+1]) {
            counter++;
          }
        }
        return groupSumClump(start + counter, nums, target) ||
        groupSumClump(start + counter, nums, target - (counter * nums[start]));
      }
      return groupSumClump(start + 1, nums, target) ||
      groupSumClump(start + 1, nums, target - nums[start]);
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
    //
    // int[] arr7 = {5, 5, 5};
    // int[] arr8 = {5, 5, 6};
    // int[] arr9 = {5, 5, 6, 1};
    // System.out.println(splitOdd10(arr7));
    // System.out.println(splitOdd10(arr8));
    // System.out.println(splitOdd10(arr9));
    //
    // int[] array1 = {1,1};
    // int[] array2 = {1,1,1};
    // int[] array3 = {2,4,2};
    // System.out.println(split53(array1));
    // System.out.println(split53(array2));
    // System.out.println(split53(array3));
    //
    // int[] array4 = {2, 5, 10, 4};
    // int[] array4Modified = {2, 5, 1, 10, 4};
    // System.out.println(groupSum5(0, array4, 19));
    // System.out.println(groupSum5(0, array4, 17));
    // System.out.println(groupSum5(0, array4, 12));
    // System.out.println(groupSum5(0, array4Modified, 21));
    // System.out.println(groupSum5(0, array4Modified, 22));
    // 
    // int[] array5 = {2,4,8};
    // int[] array6 = {1,2,4,8,1};
    // int[] array7 = {2,4,4,8};
    // System.out.println(groupSumClump(0, array5, 10));
    // System.out.println(groupSumClump(0, array6, 14));
    // System.out.println(groupSumClump(0, array7, 14));

  }
}
