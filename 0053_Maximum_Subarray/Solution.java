class Solution {
    public int maxSubArray(int[] nums) {
        int currStream = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            maxSum = Math.max(maxSum, currStream + nums[i]);
            currStream = Math.max(0, currStream + nums[i]);
        }
        return maxSum;
    }
}
