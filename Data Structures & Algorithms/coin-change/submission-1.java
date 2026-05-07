class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];

        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(1 + dp[i - coins[j]], dp[i]);
                }
            }
        }

        return dp[amount] == amount + 1? -1 : dp[amount];
    }
}
