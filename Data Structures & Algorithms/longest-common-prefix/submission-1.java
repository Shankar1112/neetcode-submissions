class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str.length() < minLen) {
                minLen = str.length();
            }
        }

        int left = 0, right = minLen - 1;
        int maxLen = -1;
        while (left <= right) {
            int mid = left + ((right -left)/2);

            if (hasCommonPrefix(left, mid, strs)) {
                maxLen = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return maxLen == -1? "" : strs[0].substring(0, maxLen + 1);
    }

    private boolean hasCommonPrefix (int start, int end, String[] strs) {
        for (int i = start; i <= end; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != c) {
                    return false;
                }
            } 
        }
        return true;
    }
}