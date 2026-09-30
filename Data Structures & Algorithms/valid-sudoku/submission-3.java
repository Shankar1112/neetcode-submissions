class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        // Check row
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (set.contains(board[i][j])) {
                        return false;
                    }
                    set.add(board[i][j]);
                }
            }
        }

        // Check col
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    if (set.contains(board[j][i])) {
                        return false;
                    }
                    set.add(board[j][i]);
                }
            }
        }

        // Check grid
        Map<Integer, Set<Character>> gridMap = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int grid = (i/3) * 3 + (j/3);
                if (gridMap.containsKey(grid)) {
                    if (gridMap.get(grid).contains(board[i][j])) {
                        return false;
                    }
                } else {
                    gridMap.put(grid, new HashSet<>());
                }
                gridMap.get(grid).add(board[i][j]);

            }
        }

        return true;
    }
}
