class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prefix = 1;
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = prefix * nums[i - 1];
            prefix = res[i];
        }
        // 1, 1, 2, 8
        int temp = nums[nums.length - 1];

        for (int i = nums.length - 2; i >= 0; i--) {
            res[i] = res[i] * temp;
            temp = temp * nums[i];
        }

        return res;
    }
}  
