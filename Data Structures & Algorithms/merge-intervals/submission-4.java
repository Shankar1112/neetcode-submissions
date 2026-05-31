class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        LinkedList<int[]> res = new LinkedList<>();
        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] currInterval = intervals[i];

            if (currInterval[0] <= res.getLast()[1]) {
                res.getLast()[1] = Math.max(res.getLast()[1], currInterval[1]);
            } else {
                res.add(currInterval);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
