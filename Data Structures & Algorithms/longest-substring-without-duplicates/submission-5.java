class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0;
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (end < s.length()) {
            char endChar = s.charAt(end);
            if (map.containsKey(endChar)) {
                start = Math.max(start, map.get(endChar) + 1);
            }
            maxLen = Math.max(maxLen, end - start + 1);
            map.put(s.charAt(end), end);
            end++;
        }
        return maxLen;
    }
}
