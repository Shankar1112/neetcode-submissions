class Solution {
    public String minWindow(String s, String t) {
        
        Map<Character, Integer> tCount = new HashMap<>();
        int uniqueChars = 0;
        for (char c: t.toCharArray()) {
            if (!tCount.containsKey(c)) {
                uniqueChars++;
            }
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }

        int start = 0, end = 0;
        int[] res = new int[3];


        int matches = 0;
        Map<Character, Integer> windowMap = new HashMap<>();

        while (end < s.length()) {
            
            char c = s.charAt(end);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            if (tCount.containsKey(c) && tCount.get(c) == windowMap.get(c)) {
                matches++;
                System.out.println(matches);
            }

            while (matches == uniqueChars && start <= end) {
                int len = end - start + 1;
                if (res[2] == 0 || len < res[2]) {
                    res[2] = len;
                    res[0] = start;
                    res[1] = end;
                }
                char startChar = s.charAt(start);
                windowMap.put(startChar, windowMap.getOrDefault(startChar, 0) - 1);
                if (tCount.containsKey(startChar) && tCount.get(startChar) > windowMap.get(startChar)) {
                    matches--;
                }
                start++;
            }
            end++;

        }

        return res[2] != 0? s.substring(res[0], res[1] + 1): "";
    }
}
