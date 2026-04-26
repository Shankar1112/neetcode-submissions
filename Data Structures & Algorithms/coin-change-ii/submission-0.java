class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;

        for (int j = coins.length - 1; j >= 0; j--) {
            for (int i = coins[j]; i <= amount; i++) {
                if (i - coins[j] >= 0) {
                    dp[i] = dp[i] + dp[i-coins[j]];
                }
            }
        }
        return dp[amount];
    }
}
