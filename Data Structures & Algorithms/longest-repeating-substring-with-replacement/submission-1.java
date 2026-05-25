class Solution {
    public int characterReplacement(String s, int k) {
        int start = 0, end = 0;
        int maxFreq = 0, longest = 0;

        Map<Character, Integer> map = new HashMap<>();
        while (end < s.length()) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(c));
            while (end - start + 1 - maxFreq > k) {
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);        
                start++;
            }
            int len = end - start + 1;
            longest = Math.max(longest, len);
            end++;

        }
        return longest;
    }
}
