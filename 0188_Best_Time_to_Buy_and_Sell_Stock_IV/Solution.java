class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k > prices.length / 2) return quickSolve(prices);
        int[] buyIn = new int[k + 1], release = new int[k + 1];
        Arrays.fill(buyIn, Integer.MIN_VALUE);
        for (int i = 0; i < prices.length; i++) {
            for (int j = k; j > 0; j--) {
                release[j] = Math.max(release[j], buyIn[j] + prices[i]);
                buyIn[j] = Math.max(buyIn[j], release[j - 1] - prices[i]);
            }
        }
        return release[k];
    }

    public int quickSolve(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
