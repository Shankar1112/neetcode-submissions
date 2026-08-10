class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(target, new ArrayList<>(), output, 0, candidates);
        return output;
    }


    void backtrack(int remain, List<Integer> curr, List<List<Integer>> output, int start, int[] candidates) {
        if (remain == 0) {
            output.add(new ArrayList(curr));
            return;
        } else if (remain < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
                        if (i > start && candidates[i] == candidates[i-1]) {
                continue;
            }
            curr.add(candidates[i]);
            backtrack(remain - candidates[i], curr, output, i+1, candidates);
            curr.remove(curr.size() - 1);

        }
    }
}
