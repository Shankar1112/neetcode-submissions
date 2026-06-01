class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());
        return res;
    }

    void backtrack(int[] nums, int i, List<Integer> curr) {
        if (i == nums.length) {
            res.add(new ArrayList(curr));
            return;
        }
        curr.add(nums[i]);
        backtrack(nums, i+1, curr);
        curr.remove(curr.size()-1);

        while (i + 1 < nums.length && nums[i] == nums[i+1]) {
            i++;
        }
        backtrack(nums, i + 1, curr);
    }
}
