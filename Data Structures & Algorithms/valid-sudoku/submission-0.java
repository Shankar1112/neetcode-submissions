class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> colMap = new HashMap<>();
        Map<Integer, Set<Character>> gridMap = new HashMap<>();
        int rowLength = board.length;
        int colLength = board[0].length;
        for (int i = 0; i < rowLength; i++)  {
            for (int j = 0; j < colLength; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                // Check Row
                if (rowMap.containsKey(i)) {
                    if (rowMap.get(i).contains(board[i][j])) {
                        return false;
                    }
                } else {
                    rowMap.put(i, new HashSet<Character>());
                }
                rowMap.get(i).add(board[i][j]);

                // Check Col
                if (colMap.containsKey(j)) {
                    if (colMap.get(j).contains(board[i][j])) {
                        return false;
                    }
                } else {
                    colMap.put(j, new HashSet<Character>());
                }
                colMap.get(j).add(board[i][j]);

                int grid = (i/3)*3+(j/3);
                if (gridMap.containsKey(grid)) {
                    if (gridMap.get(grid).contains(board[i][j])) {
                        return false;
                    }
                } else {
                    gridMap.put(grid, new HashSet<Character>());
                }
                gridMap.get(grid).add(board[i][j]);
            }
        }
        return true;
    }
}
