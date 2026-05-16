class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0;
        int longest = 0, maxFreq = 0;

        Map<Character, Integer> count = new HashMap<>();
        while (right < s.length()) {
            count.put(s.charAt(right), count.getOrDefault(s.charAt(right), 0) + 1);
            maxFreq = Math.max(maxFreq, count.get(s.charAt(right)));

            while (right - left + 1 - maxFreq > k) {
                count.put(s.charAt(left), count.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            }
            longest = Math.max(longest, right - left + 1);
            right++;
        }
        return longest;
    }
}
