import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_51 {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        backTracking(n, 0, chessboard);
        return res;
    }

    public void backTracking(int n, int row, char[][] chessboard) {
        if (row == n) {
            res.add(array2List(chessboard));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(row, i, n, chessboard)) {
                chessboard[row][i] = 'Q';
                backTracking(n, row + 1, chessboard);
                chessboard[row][i] = '.';
            }
        }
    }

    public List array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();
        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }

    public boolean isValid(int row, int col, int n, char[][] chessboard) {
        // 检查列
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }
        // 检查45斜角
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        // 检查135斜角
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
