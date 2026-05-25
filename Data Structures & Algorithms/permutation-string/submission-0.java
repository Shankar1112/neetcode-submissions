class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        int s1Len = s1.length();
        int s2Len = s2.length();
        for (int i = 0; i < s1Len; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        int matches = 0;

        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i]) {
                matches++;
            }
        }

        if (matches == 26) {
            return true;
        }

        for (int i = s1Len; i < s2Len; i++) {
            s2Count[s2.charAt(i - s1Len) - 'a']--;
            if (s2Count[s2.charAt(i - s1Len) - 'a'] == s1Count[s2.charAt(i - s1Len) - 'a']) {
                matches++;
            } else if (s2Count[s2.charAt(i - s1Len) - 'a'] + 1 == s1Count[s2.charAt(i - s1Len) - 'a']) {
                matches--;
            }
            s2Count[s2.charAt(i) - 'a']++;
            if (s2Count[s2.charAt(i) - 'a'] == s1Count[s2.charAt(i) - 'a']) {
                matches++;
            } else if (s2Count[s2.charAt(i) - 'a'] - 1 == s1Count[s2.charAt(i) - 'a']) {
                matches--;
            }
            if (matches == 26) {
                return true;
            }
        }
        return false;
    }
}
