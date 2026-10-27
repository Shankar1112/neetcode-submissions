class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Check row
        for (int i = 0; i < 9; i++) {
            Set<Character> row = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (row.contains(board[i][j])) {
                        return false;
                    }
                    row.add(board[i][j]);
                }
            }
        }

        // Check col
        for (int j = 0; j < 9; j++) {
            Set<Character> col = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    if (col.contains(board[i][j])) {
                        return false;
                    }
                    col.add(board[i][j]);
                }
            }
        }

        // Check grid
        Map<Integer, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int grid = (i / 3) * 3 + (j / 3);
                Set<Character> set = map.getOrDefault(grid, new HashSet<>());
                if (set.contains(board[i][j])) {
                    System.out.println("Failed here " + i + " " + j + " " + grid);
                    return false;
                }
                set.add(board[i][j]);
                map.put(grid, set);
            }
        }

        return true;
    }
}
