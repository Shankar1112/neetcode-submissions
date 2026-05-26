class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tCount = new HashMap<>();

        for (char c: t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }

        int uniqueChars = tCount.size();
        int start = 0, end = 0, minimum = Integer.MAX_VALUE;

        int[] res = new int[2];
        Map<Character, Integer> windowMap = new HashMap<>();
        int matches = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
            if (tCount.containsKey(c) && windowMap.get(c) == tCount.get(c)) {
                matches++;
            }
            while (start <= end && matches == uniqueChars) {
                int len = end - start + 1;
                if (minimum > len) {
                    minimum = len;
                    res[0] = start;
                    res[1] = end;
                }
                char startChar = s.charAt(start);
                windowMap.put(startChar, windowMap.get(startChar) - 1);
                if (tCount.containsKey(startChar) && windowMap.get(startChar) < tCount.get(startChar)) {
                    matches--;
                }
                start++;
            }
            end++;
        }
        return minimum != Integer.MAX_VALUE ? s.substring(res[0], res[1] + 1) : "";
    }
}
