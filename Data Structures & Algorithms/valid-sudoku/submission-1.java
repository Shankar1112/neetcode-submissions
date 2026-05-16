class Solution {
    public boolean isValidSudoku(char[][] board) {

        // Check row    
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9 ; j++) {
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
            for (int j = 0; j < 9 ; j++) {
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
                int gridVal =  (i/3)*3 + j/3;
                Set<Character> set = new HashSet<>();
                if (gridMap.containsKey(gridVal)) {
                    set = gridMap.get(gridVal);
                    if (set.contains(board[i][j])) {
                        System.out.println(i + " - " + j + " - " + gridVal);
                        return false;
                    }
                }
                set.add(board[i][j]);
                gridMap.put(gridVal, set);
            }
        }
       
        return true;
    }
}
