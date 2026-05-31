class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), res, new boolean[nums.length]);
        return res;
    }

    void backtrack(int[] nums, List<Integer> curr, 
    List<List<Integer>> res, boolean[] pick) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (!pick[i]) {
                pick[i] = true;
                curr.add(nums[i]);
                backtrack(nums, curr, res, pick);
                curr.remove(curr.size() - 1);
                pick[i] = false;
            }
        }

    }
}
