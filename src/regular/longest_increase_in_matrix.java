package regular;

public class longest_increase_in_matrix {
    private int[][] memory;
    private int[][] positions = {{0,1}, {0,-1}, {1,0}, {-1,0}}; // 上下左右
    int m,n;
    public int longestIncreasingPath(int[][] matrix) {
        // 记忆化dfs
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        m = matrix.length;
        n = matrix[0].length;
        memory = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(matrix, i, j));
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int i, int j) {
        if (memory[i][j] != 0) return memory[i][j]; // 记忆化，防止重复递归
        int maxlen = 1;
        for (int[] pos : positions) {
            int x = i + pos[0], y = j + pos[1]; //当前位置的上下左右
            if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
                int len = 1 + dfs(matrix, x, y);
                maxlen = Math.max(maxlen, len);
            }
        }
        memory[i][j] = maxlen;
        return maxlen;
    }
}
