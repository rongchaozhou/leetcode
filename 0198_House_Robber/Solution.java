class Solution {

  public int rob(int[] nums) {
    int include = 0, exclude = 0;
    for (int i = 0; i < nums.length; i++) {
      int temp = include;
      include = exclude + nums[i];
      exclude = Math.max(exclude, temp);
    }
    return Math.max(include, exclude);
  }
}
