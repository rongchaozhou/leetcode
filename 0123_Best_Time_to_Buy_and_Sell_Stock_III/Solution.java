class Solution {
    public int maxProfit(int[] prices) {
        int buyIn1 = Integer.MIN_VALUE, buyIn2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for (int i = 0; i < prices.length; i++) {
            release2 = Math.max(release2, release1 + buyIn2 + prices[i]);
            buyIn2 = Math.max(buyIn2, release1 - prices[i]);
            release1 = Math.max(release1, buyIn1 + prices[i]);
            buyIn1 = Math.max(buyIn1, -prices[i]);
        }
        return release2;
    }
}
