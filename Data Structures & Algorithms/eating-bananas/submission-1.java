class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for (int pile : piles) {
            maxPile = Math.max(pile, maxPile);
        }

        int left = 1, right = maxPile;

        int res = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;
            // total hours
            int totalHours = 0;
            for (int pile : piles) {
                totalHours += Math.ceil((double) pile / mid);
            }
            if (totalHours <= h) {
                res = Math.min(mid, res);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}
