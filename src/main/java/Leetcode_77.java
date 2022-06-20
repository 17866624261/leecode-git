import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_77 {
    static LinkedList<Integer> path = new LinkedList<>();
    static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        System.out.println(combine(n, k).toString());
    }

    public static List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }

    public static void backtracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtracking(n, k, i + 1);
            path.removeLast();
        }
    }
}
