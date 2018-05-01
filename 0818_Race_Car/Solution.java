class Solution {
    int[] dp = new int[10001];

    public int racecar(int target) {
        if (dp[target] > 0) {
            return dp[target];
        }
        int n = 0;
        while ((1 << n + 1) - 1 <= target) {
            n++;
        }
        //so we have 2^n - 1 <= target < 2^(n + 1) -1
        if ((1 << n) - 1 == target) {
            return n;
        } else {
            dp[target] = n + 2 + racecar((1 << n + 1) - 1 - target);
            for (int m = 0; m < n; m++) {
                dp[target] = Math.min(dp[target], n + 1 + m + 1 + racecar(target - (1 << n) + (1 << m)));
            }
        }
        return dp[target];
    }
}
