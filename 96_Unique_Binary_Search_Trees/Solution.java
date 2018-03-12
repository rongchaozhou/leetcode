class Solution {
    public int numTrees(int n) {
        if(n == 0) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i = 1; i < n + 1; i++) {
            for(int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1]; //dp[i] is composed of dp[j] for left, 1 for root, and dp[i - j - 1] for right
            }
        }
        return dp[n];
    }
}
