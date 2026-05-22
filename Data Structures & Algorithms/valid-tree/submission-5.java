class DSU {
    int[] parent;
    int[] rank;

    int count;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        count = n;
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
        System.out.println(x + " - " + y + " - " + px + " - " + py);
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
        count--;
        return true;
    }
}

class Solution {
    public boolean validTree(int n, int[][] edges) {
        DSU dsu = new DSU(n);

        for (int[] edge: edges) {
            if (!dsu.union(edge[0], edge[1])) {
                return false;
            }
        }
        System.out.println(dsu.count);
        return dsu.count == 1;
    }
}
