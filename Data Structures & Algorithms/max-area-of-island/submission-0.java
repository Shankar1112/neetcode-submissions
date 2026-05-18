class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int maxArea = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    int depth = dfs(grid, i, j);
                    maxArea = Math.max(maxArea, depth);
                }
            }
        }
        return maxArea;
    }

    int dfs(int[][] grid, int row, int col) {
        int depth = 1;
        grid[row][col] = 0;
        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : dirs) {
            int newRow = dir[0] + row;
            int newCol = dir[1] + col;

            if (newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length || grid[newRow][newCol] == 0) {
                continue;
            }

            depth += dfs(grid, newRow, newCol);
        }
        return depth;
    }
}
