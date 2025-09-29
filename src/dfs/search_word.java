package dfs;

public class search_word {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int k) {
        // 结束条件
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if (board[i][j] != word.charAt(k)) return false;
        // 匹配到最后一个字符
        if (k == word.length() - 1) return true;
        // 临时标记，防止重复使用同一个格子
        char tmp = board[i][j];
        board[i][j] = '#';

        boolean res = dfs(board,word, i+1, j, k+1) ||
                dfs(board, word, i-1, j, k+1) ||
                dfs(board, word, i, j+1, k+1) ||
                dfs(board, word, i, j-1, k+1);

        board[i][j] = tmp;
        return res;
    }
}
