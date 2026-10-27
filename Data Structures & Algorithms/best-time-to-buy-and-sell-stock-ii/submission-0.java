class Solution {
    public int maxProfit(int[] prices) {
        int minSoFar = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > minSoFar) {
                maxProfit += prices[i] - minSoFar;
                minSoFar = prices[i];
            } else {
                minSoFar = prices[i];
            }
        }
        return maxProfit;
    }
}