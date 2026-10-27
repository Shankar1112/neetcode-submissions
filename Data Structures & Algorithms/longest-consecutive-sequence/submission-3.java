class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            }

            int i = 1;
            while (set.contains(num + 1)) {
                num = num + 1;
                i++;
            }
            if (i > longest) {
                longest = i;
            }
        }
        return longest;
    }
}
