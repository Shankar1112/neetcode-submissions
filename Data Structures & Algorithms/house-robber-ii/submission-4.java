class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1) );
    }

    public int rob(int[] nums, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (end - start + 1 == 1) {
            return nums[start];
        }
        int[] dp = new int[nums.length];

        dp[start] = nums[start];
        dp[start+ 1] = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[end];
    }
}
