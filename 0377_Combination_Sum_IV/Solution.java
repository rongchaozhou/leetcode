class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int k : nums) {
                if (i - k < 0) continue;
                dp[i] += dp[i - k];
            }
        }
        return dp[target];
    }
}