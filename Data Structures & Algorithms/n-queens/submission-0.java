class Solution {
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtrack(0, board, res);
        return res;
    }

    void backtrack(int r, char[][] board, List<List<String>> res) {

        //Base case
        if (r == board.length) {
            List<String> curr = new ArrayList<>();
            for (char[] row : board) {
                curr.add(new String(row));
            }
            res.add(curr);
            return;
        }


        // Iterate over choices
        for (int j = 0; j < board.length; j++) {
            if (isSafe(r, j, board)) {
                board[r][j] = 'Q';
                backtrack(r + 1, board, res);
                board[r][j] = '.';
            }
        }
    }

private boolean isSafe(int r, int c, char[][] board) {
        for (int i = r - 1; i >= 0; i--) {
            if (board[i][c] == 'Q') return false;
        }
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        for (int i = r - 1, j = c + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
}
