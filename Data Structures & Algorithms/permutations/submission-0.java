class Solution {
    List<List<Integer>> res = new ArrayList<>(); 
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new boolean[nums.length], new ArrayList<>());
        return res;
    }

    void backtrack(int[] nums, boolean[] pick, List<Integer> perm) {
        if (perm.size() == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!pick[i]) {
                perm.add(nums[i]);
                pick[i] = true;
                backtrack(nums, pick, perm);
                perm.remove(perm.size()-1);
                pick[i] = false;
            }

        }
    }
}
