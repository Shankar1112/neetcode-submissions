class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        if (matrix.length == 0) {
            return res;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0, right = n - 1, up = 0, down = m - 1;

        while (res.size() < m * n) {
            // left to right
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }

            // up to down
            for (int i = up + 1; i <= down; i++) {
                res.add(matrix[i][right]);
            }

            // right to left
            if (up != down) {
                for (int i = right - 1; i >= left; i--) {
                    res.add(matrix[down][i]);
                }
            }

            // down to up
            if (left != right) {
                for (int i = down - 1; i > up; i--) {
                    res.add(matrix[i][left]);
                }
            }


            left++;
            right--;
            up++;
            down--;
        }
        return res;
    }
}
