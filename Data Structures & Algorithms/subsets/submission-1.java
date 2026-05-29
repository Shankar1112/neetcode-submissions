class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, nums.length - 1, new ArrayList<>());
        return res;
    }

    void backtrack(int[] nums, int left, int right, List<Integer> curr) {   
        res.add(new ArrayList(curr));
 
        for (int i = left; i <= right; i++) {
            System.out.println(nums[i]);
            curr.add(nums[i]);
            backtrack(nums, i + 1, right, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
