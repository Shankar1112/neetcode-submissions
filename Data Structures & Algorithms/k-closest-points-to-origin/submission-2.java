class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> dist(b) - dist(a));

        for (int[] point : points) {
            pq.offer(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] res = new int[pq.size()][2];
        for (int i = 0 ; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;

    }

    int dist(int[] a) {
        return a[0] * a[0] + a[1] * a[1];
    }
}
