class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int k = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                break;
            }
            if (nums[i] == val) {
                while ( k > i && nums[k] == val) {
                    k--;
                }
                if (k > i) {
                    int temp = nums[k];
                    nums[k] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return nums[k] != val? k + 1: k;
    }
}