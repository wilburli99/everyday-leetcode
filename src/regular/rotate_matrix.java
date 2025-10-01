package regular;

public class rotate_matrix {
    public void rotate(int[][] matrix) {
        // 先转置 matrix[i][j] -- matrix[j][i]
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = i+1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // 再反转每行
        for (int i = 0; i < m; i++) {
            int left = 0, right = n-1;
            while (left < right) {
                int tmp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = tmp;
                left++;
                right--;
            }
        }
    }
}
