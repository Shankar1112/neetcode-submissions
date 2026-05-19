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

    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);

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
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        int connected = n;
        for (int[] edge : edges) {
            if (dsu.union(edge[0], edge[1])) {
                connected--;
            }
        }
        return connected;
    }
}
