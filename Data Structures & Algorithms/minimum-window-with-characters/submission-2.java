class Solution {
    public String minWindow(String s, String t) { 
        Map<Character, Integer> tCount = new HashMap<>();

        for (char c: t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }
        int uniqueChars = tCount.size();

        int left = 0, right = 0, len = s.length();

        int formed = 0;
        int[] res = new int[2];
        int minLen = Integer.MAX_VALUE;

        Map<Character, Integer> windowMap = new HashMap<>();

        while (right < len) {
                char c = s.charAt(right);
                windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
                if (tCount.containsKey(c) && tCount.get(c) == windowMap.get(c)) {
                    formed++;
                    while (left <= right && formed == uniqueChars) {
                        int currWindowLen = right - left;
                        if (currWindowLen < minLen) {
                            minLen = currWindowLen;
                            res[0] = left;
                            res[1] = right;
                        }
                        char startChar = s.charAt(left);
                        System.out.println(left + " - " +windowMap.get(startChar));
                        windowMap.put(startChar, windowMap.getOrDefault(startChar, 0) - 1);
                        if (tCount.containsKey(startChar) && windowMap.get(startChar) < tCount.get(startChar)) {
                            formed--;
                        }
                        left++;
                    }
                }
                right++;


        }
        return minLen != Integer.MAX_VALUE ? s.substring(res[0], res[1] + 1): "";
    }
}
