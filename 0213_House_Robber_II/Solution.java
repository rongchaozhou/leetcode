class Solution {

  public int rob(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    return Math.max(rob(nums, 1, nums.length - 1), nums[0] + rob(nums, 2, nums.length - 2));
  }

  private int rob(int[] nums, int start, int end) {
    int include = 0, exclude = 0;
    for (int i = start; i <= end; i++) {
      int temp = include;
      include = exclude + nums[i];
      exclude = Math.max(exclude, temp);
    }
    return Math.max(include, exclude);
  }
}
