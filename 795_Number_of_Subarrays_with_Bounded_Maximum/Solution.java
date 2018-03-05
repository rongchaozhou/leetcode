class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int ans = 0;
        int[][] dp = new int[A.length + 1][2];
        for (int i = 0; i < A.length; i++) {
            if (A[i] < L) {
                dp[i + 1][0] = dp[i][0];
                dp[i + 1][1] = dp[i][1] + 1;
                ans += dp[i + 1][0];
            } else if (A[i] > R) {
                dp[i + 1][0] = 0;
                dp[i + 1][1] = 0;
            } else {
                dp[i + 1][0] = dp[i][0] + dp[i][1] + 1;
                dp[i + 1][1] = 0;
                ans += dp[i + 1][0];
            }
        }
        return ans;
    }
}
