class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length > n - 1) {
            return false;
        }
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, -1});
        visited.add(0);
        while (!q.isEmpty()) {
            int[] pair = q.poll();
            int node = pair[0], parentNode = pair[1];
            for (int nei : adj.get(node)) {
                if (nei == parentNode) {
                    continue;
                }
                if (visited.contains(nei)) {
                    return false;
                }
                visited.add(nei);
                q.offer(new int[]{nei, node});
            }
        }
        return visited.size() == n;
    }
}
