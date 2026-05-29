class DSU {
    int[] parent;
    int[] rank;

    public DSU (int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int find (int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    boolean union(int x, int y) {
        int px = find(x), py = find(y);

        if (px == py) {
            return false;
        }

        if (rank[px] > rank[py]) {
            parent[py] = px;
        } else if (rank[px] < rank[py]) {
            parent[px] = py;
        } else {
            parent[py] = px;
            rank[px]++;
        }
        return true;
    }
}
class Solution {
    public boolean validTree(int n, int[][] edges) {
        DSU dsu = new DSU(n);

        if (edges.length != n-1) {
            return false;
        }
        for (int[] edge: edges) {
            if (!dsu.union(edge[0], edge[1])) {
                return false;
            }
        }
        return true;
    }
}
