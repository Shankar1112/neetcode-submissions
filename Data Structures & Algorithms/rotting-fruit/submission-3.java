class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        int mins = 0;
        int[][] dirs = new int[][] {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };
        while (!queue.isEmpty() && fresh != 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] dir : dirs) {
                    int newRow = dir[0] + curr[0];
                    int newCol = dir[1] + curr[1];
                    if (newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length || grid[newRow][newCol] != 1) {
                        continue;
                    }
                    grid[newRow][newCol] = 2;
                    fresh--;
                    queue.offer(new int[] {newRow, newCol});
                }
            }
            mins++;
        }
        return fresh == 0? mins : -1;
    }
}
