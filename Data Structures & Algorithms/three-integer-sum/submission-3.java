class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int first = nums[i];
            if (first > 0) {
                break;
            }

            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int second = nums[left];
                int third = nums[right];
                int sum = first + second + third;
                if (sum == 0) {
                    res.add(Arrays.asList(first, second, third));
                    left++;
                    right--;
                    while (left < right && nums[left] == second) {
                        left++;
                    }
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}
