class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int row = 0;
        for (int i = 0; i < rowLength; i++) {
            if (matrix[i][0] <= target && matrix[i][colLength-1] >= target) {
                row = i;
            }
        }
        int i = 0;
        int j = colLength-1;
        while (i <= j) {
            int m = (i + j)/2;
            if (matrix[row][m] > target) {
                j = m - 1;
            } else if (matrix[row][m] < target) {
                i = m+1;
            } else {
                return true;
            }
        }
        return false;
    }
}
