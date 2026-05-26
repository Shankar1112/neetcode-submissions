class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0, down = matrix.length - 1;
        int rows = matrix.length;
        int cols = matrix[0].length;

        int mid = 0;
        // Find the row
        while (top <= down) {
            mid = (top + down)/2;

            if (matrix[mid][0] > target) {
                down = mid - 1;
            } else if (matrix[mid][cols-1] < target) {
                top = mid + 1;
            } else {
                break;
            }
        }

        int left = 0, right = cols - 1;
        int currRow = mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (matrix[currRow][mid] == target) {
                return true;
            } else if (matrix[currRow][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
}
