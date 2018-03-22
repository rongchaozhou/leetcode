class Solution {
    public int maxProfit(int[] prices) {
        int buyIn = Integer.MIN_VALUE, release = 0;
        for (int i = 0; i < prices.length; i++) {
            release = Math.max(release, buyIn + prices[i]);
            buyIn = Math.max(buyIn, -prices[i]);
        }
        return release;
    }
}
