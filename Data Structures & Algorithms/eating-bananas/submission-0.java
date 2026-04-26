class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;

        // Find max
        for (int pile: piles) {
            if (pile > max) {
                max = pile;
            }
        }

        // Binary search
        int l = 1, r = max;
        int res = r;

        while (l <= r) {
            int mid = (l + r)/2;

            int hours = 0;
            for (int pile: piles) {
                hours += Math.ceil((double) pile/mid);
            }
            if (hours > h) {
                l = mid + 1;
            } else {
                res = mid;
                r = mid - 1;
            }
        }
        return res;
    }
}
