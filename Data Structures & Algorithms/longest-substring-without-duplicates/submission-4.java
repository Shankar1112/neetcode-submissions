class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0;
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }
            maxLen = Math.max(maxLen, end - start + 1);
            map.put(c, end);
            end++;

        }
        return maxLen;
    }
}
