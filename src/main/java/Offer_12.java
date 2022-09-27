import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class Offer_12 {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
        if (i>=board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != s.charAt(k) || visited[i][j]) {
            return false;
        }
        if (k == s.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        boolean res = check(board, visited, i + 1, j, s, k + 1) ||
                check(board, visited, i, j + 1, s, k + 1) ||
                check(board, visited, i - 1, j, s, k + 1) ||
                check(board, visited, i, j - 1, s, k + 1);
        visited[i][j] = false;
        return res;
    }
}
