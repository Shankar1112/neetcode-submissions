class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if (s.length() <= 1) {
            return s.length();
        }

        int start = 0, end = 0;
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (end < s.length()) {
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(start, map.get(s.charAt(end)) + 1);
            }
            int len = end - start + 1;
            maxLen = Math.max(maxLen, len);
            map.put(s.charAt(end), end);
            end++;
        }
        return maxLen;
    }
}
