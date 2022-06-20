import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_39 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    @Test
    public static void test39(String[] args) {
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTracking(candidates, target, 0, 0);
        return result;
    }

    public void backTracking(int[] candidates, int target, int sum, int startIndex) {
        // 返回条件
        if (sum >= target) {
            if (sum == target) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        // 单层循环逻辑
        for (int i = startIndex; i < candidates.length; i++) {
            if (sum > target) break;
            path.add(candidates[i]);
            backTracking(candidates, target, sum + candidates[i], i);
            sum -= candidates[i];
            path.removeLast();
        }
    }
}
