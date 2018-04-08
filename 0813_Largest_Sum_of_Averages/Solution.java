class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        int[] sum = new int[A.length];
        sum[0] = A[0];
        for (int j = 1; j < A.length; j++) {
            sum[j] = A[j] + sum[j - 1];
        }

        double[][] dp = new double[K][A.length];
        for (int j = 0; j < A.length; j++) {
            dp[0][j] = (double) sum[j] / (j + 1);
        }

        for (int i = 1; i < K; i++) {
            for (int j = i; j < A.length; j++) {
                for (int k = i - 1; k <= j - 1; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + (double) (sum[j] - sum[k]) / (j - k));
                }
            }
        }
        return dp[K - 1][A.length - 1];
    }
}
