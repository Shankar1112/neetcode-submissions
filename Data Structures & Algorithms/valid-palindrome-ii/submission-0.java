class Solution {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return validPalindrome(left+1, right, s) || validPalindrome(left, right - 1, s);
            }
            left++;
            right--;
        }
        return true;
    }

    boolean validPalindrome(int left, int right, String s) {
        while (left < right) {
            char c = s.charAt(left);
            char d = s.charAt(right);
            if (c != d) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}