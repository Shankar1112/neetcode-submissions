class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        if (s1.length() > s2.length()) {
            return false;
        }

        for (char c : s1.toCharArray()) {
            s1Count[c - 'a']++;
        }

        for (int i = 0; i < s1.length(); i++) {
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

        for (int i = s1.length(); i < s2.length(); i++) {
            char startChar = s2.charAt(i - s1.length());
            if (s1Count[startChar - 'a'] == s2Count[startChar - 'a']) {
                matches--;
            } else if (s1Count[startChar - 'a'] + 1 == s2Count[startChar - 'a']) {
                matches++;
            }
            s2Count[startChar - 'a']--;

            char endChar = s2.charAt(i);
            s2Count[endChar - 'a']++;
            if (s2Count[endChar - 'a'] == s1Count[endChar - 'a']) {
                matches++;
            } else if (s2Count[endChar - 'a'] == s1Count[endChar - 'a'] + 1) {
                matches--;
            }

            if (matches == 26) {
                return true;
            }
            
        }
        return false;
    }
}
