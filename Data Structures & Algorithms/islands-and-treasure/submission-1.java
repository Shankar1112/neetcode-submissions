class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[] {i , j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int[][] dirs = new int[][] {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
            };
            for (int[] dir : dirs) {
                int newRow = dir[0] + curr[0];
                int newCol = dir[1] + curr[1];

                if (newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length || grid[newRow][newCol] != Integer.MAX_VALUE) {
                    continue;
                }
                grid[newRow][newCol] = grid[curr[0]][curr[1]] + 1;
                queue.offer(new int[] {newRow, newCol});
            }
        }
    }
}
