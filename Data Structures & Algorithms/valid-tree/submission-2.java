class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length > n - 1) {
            return false;
        }

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[1]).add(edge[0]);
            adjList.get(edge[0]).add(edge[1]);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, -1});

        Set<Integer> visited = new HashSet<>();
        visited.add(0);

        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            
            int currNode = pair[0], parentNode = pair[1];
            for (int adjNode : adjList.get(currNode)) {
                if (adjNode == parentNode) {
                    continue;
                }
                if (visited.contains(adjNode)) {
                    return false;
                }
                visited.add(adjNode);
                queue.offer(new int[]{adjNode, currNode});
            }
        }

        return visited.size() == n;
    }
}
