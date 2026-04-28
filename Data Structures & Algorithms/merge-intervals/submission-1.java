class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        LinkedList<int[]> res = new LinkedList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] currInterval = intervals[i];
            if (currInterval[0] > res.getLast()[1]) {
                res.add(currInterval);
            } else {
                res.getLast()[1] = Math.max(currInterval[1], res.getLast()[1]);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
