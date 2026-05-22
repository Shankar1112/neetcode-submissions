class Edge {
    int point1, point2, cost;

    public Edge(int point1, int point2, int cost) {
        this.point1 = point1;
        this.point2 = point2;
        this.cost = cost;
    }
}

class DSU {
    int[] parent;
    int[] rank;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) {
            return false;
        }

        if (rank[px] > rank[py]) {
            parent[py] = px;
        } else if (rank[py] > rank[px]) {
            parent[px] = py;
        } else {
            parent[py] = px;
            rank[px]++;
        }
        return true;
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<Edge>((a, b) -> a.cost - b.cost);
        for (int i = 0; i < points.length; i++) {
            int[] first = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int[] second = points[j];
                int cost = Math.abs(first[0] - second[0]) + 
                           Math.abs(first[1] - second[1]);
                pq.offer(new Edge(i, j, cost));
            }
        }
        int count = 0;
        int minCost = 0;
        DSU dsu = new DSU(points.length);
        while (!pq.isEmpty() && count < points.length) {
            Edge curr = pq.poll();
            if (dsu.union(curr.point1, curr.point2)) {
                minCost += curr.cost;
                count++;
            }
        }
        return minCost;
    }
}
