class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0, right = matrix.length - 1;
        int rows = matrix.length, cols = matrix[0].length;
        boolean found = false;
        int currRow = -1;
        while (!found && left <= right) {
            int mid = (left + right)/2;
            System.out.println(left + "-" + mid + "-" + right);
            if (matrix[mid][cols - 1] < target) {
                left = mid + 1;
            } else if (matrix[mid][0] > target) {
                right = mid - 1;
            } else {
                found = true;
                currRow = mid;
            }
        }
        if (!(left <= right)) {
            return false;
        }
        left = 0;
        right = matrix[0].length;

        while (currRow != -1 && currRow < rows && left <= right) {
            int mid = (left + right)/2;
            if (matrix[currRow][mid] == target) {
                return true;
            }
            if (matrix[currRow][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return false;
    }
}
