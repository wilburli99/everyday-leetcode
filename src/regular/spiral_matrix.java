package regular;

import java.util.ArrayList;
import java.util.List;

public class spiral_matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix == null) return res;
        int m = matrix.length, n = matrix[0].length;
        int top = 0, left = 0;
        int last = m - 1, right = n - 1;
        while (top <= last && left <= right) {
            // 从左到右
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++; // 收缩边界防止重复数字
            // 从上到下
            for (int j = top; j <= last; j++) {
                res.add(matrix[j][right]);
            }
            right--;
            if (top <= last) {
                // 从右到左
                for (int k = right; k >= left; k--) {
                    res.add(matrix[last][k]);
                }
                last--;
            }
            if (left <= right) {
                // 从下到上
                for (int l = last; l >= top; l--) {
                    res.add(matrix[l][left]);
                }
                left++;
            }
        }
        return res;
    }
}
