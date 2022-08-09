import org.junit.Test;

public class Offer_13 {
    @Test
    public void testMoving() {
        System.out.println(movingCount(2, 3, 1));
    }

    public int movingCount(int m, int n, int k) {
        if (m <= 0 || n <= 0 || k < 0) {
            return 0;
        }
        boolean[] visited = new boolean[m * n];
        return movingCore(m, n, 0, 0, k, visited);
    }

    public int movingCore(int m, int n, int i, int j, int k, boolean[] visited) {
        int count = 0;
        if (check(m, n, i, j, k, visited)) {
            visited[i * n + j] = true;
            count = 1 + movingCore(m, n, i + 1, j, k, visited) +
                    movingCore(m, n, i - 1, j, k, visited) +
                    movingCore(m, n, i, j + 1, k, visited) +
                    movingCore(m, n, i, j - 1, k, visited);
        }
        return count;
    }

    public boolean check(int m, int n, int i, int j, int k, boolean[] visited) {
        if (i >= 0 && i < m && j >= 0 && j < n && !visited[i * n + j] && getSum(i, j) <= k) {
            return true;
        }
        return false;
    }

    public int getSum(int i, int j) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        while (j > 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum;
    }
}
