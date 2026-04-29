class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            int distance = squaredDistance(point);
            pq.offer(new int[] {distance, i});
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[][] result = new int[k][2];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = points[pq.poll()[1]];
        }
        return result;
    }

    private int squaredDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
