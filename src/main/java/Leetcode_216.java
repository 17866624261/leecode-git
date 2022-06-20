import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_216 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(k, n, 1, 0);
        return result;
    }

    public void backTracking(int k, int n, int startIndex, int sum) {
        if (sum > n) {
            return;
        }
        if (path.size() == k) {
            if (sum == n)
                result.add(new ArrayList<>(path));
        }
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            backTracking(k, n, i + 1, sum);
            path.removeLast();
            sum -= i;
        }
    }
}
