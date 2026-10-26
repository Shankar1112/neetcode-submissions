class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int maxCount = 0;
        int maxNum = -1;
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > maxCount) {
                maxCount = map.get(num);
                maxNum = num;
            }
        }

        return maxNum;
    }
}