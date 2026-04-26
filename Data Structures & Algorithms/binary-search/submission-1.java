class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int i = 0;
        int j = len-1;
        while (i <= j) {
            int middle = i + ((j - i)/2);
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                i = middle + 1;

            } else if (nums[middle] > target) {
                j = middle - 1;
            }

        }
        return -1;
    }
}
