class Solution {
    public int maxCoins(int[] nums) {
        int[] coin = new int[nums.length + 2];
        int n = 1;
        for (int k : nums) {
            if (k != 0) {
                coin[n] = k;
                n++;
            }
        }
        coin[0] = 1;
        coin[n] = 1;
        int[][] memo = new int[n + 1][n + 1];
        return burst(memo, coin, 0, n);
    }

    private int burst(int[][] memo, int[] coin, int left, int right) {
        if (left == right - 1) return 0;
        if (memo[left][right] > 0) return memo[left][right];
        int max = 0;
        for (int i = left + 1; i < right; i++) {
            max = Math.max(max, coin[left] * coin[i] * coin[right] + burst(memo, coin, left, i) + burst(memo, coin, i, right));
        }
        memo[left][right] = max;
        return max;
    }
}
