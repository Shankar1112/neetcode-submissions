class Solution {
    public int numIslands(char[][] grid) {

        int numIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    dfs(grid, i, j);
                }
            }
        }
        return numIslands;
    }

    void dfs(char[][] grid, int row, int col) {
        grid[row][col] = '0';

        int[][] dirs = new int[][] {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        for (int[] dir: dirs) {
            int newRow = dir[0] + row;
            int newCol = dir[1] + col;

            if (newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length || grid[newRow][newCol] == '0') {
                continue;
            }
            dfs(grid, newRow, newCol);
        }
    }
}
