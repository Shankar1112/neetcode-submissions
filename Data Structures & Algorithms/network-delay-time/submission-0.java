class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] time: times) {
            List<int[]> currAdj = adjList.get(time[0]);
            currAdj.add(new int[] {time[1], time[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); 
        pq.offer(new int[] {k, 0});

        Set<Integer> visited = new HashSet<>();

        int time = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (visited.contains(curr[0])) {
                continue;
            }

            visited.add(curr[0]);
            time = curr[1];
            for (int[] adj : adjList.get(curr[0])) {
                if (!visited.contains(adj[0])) {
                    pq.offer(new int[] {adj[0], curr[1] + adj[1] });
                }
            }
        }
        return visited.size() == n ? time : -1;
    }
}
