class Solution {
    public int maxProfit(int[] prices) {
        int i = 0 , j = 1;
        int maxProfit = 0;
        while (j < prices.length) {
            int diff = prices[j] - prices[i];
            if (diff > maxProfit) {
                maxProfit = diff;
            }
            if (diff < 0) {
                i = j;
            }
            j++;
        }
        return maxProfit;
    }
}
