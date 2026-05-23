class Solution {
    public boolean isValidSudoku(char[][] board) {
        // row 
        for (int i = 0; i < board.length; i++) {
            Set<Character> rowSet = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    if (rowSet.contains(board[i][j])) {
                        return false;
                    }
                    rowSet.add(board[i][j]);
                }
            }
        }

        // col 
        for (int i = 0; i < board[0].length; i++) {
            Set<Character> colSet = new HashSet<>();
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] != '.') {
                    if (colSet.contains(board[j][i])) {
                        return false;
                    }
                    colSet.add(board[j][i]);
                }
            }
        }

        // grid
        Map<Integer, Set<Character>> gridMap = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int grid = (i /3) * 3 + j/3;
                    Set<Character> set = gridMap.getOrDefault(grid, new HashSet<>());
                    if (set.contains(board[i][j])) {
                        return false;
                    }
                    set.add(board[i][j]);
                    gridMap.put(grid, set);
                }
            }
        }
        return true;
    }
}
