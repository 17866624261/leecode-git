import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_40 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int sum;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean[] flag = new boolean[candidates.length];
        backTracking(candidates, target, 0, flag);
        return result;
    }

    public void backTracking(int[] candidates, int target, int startIndex, boolean[] flag) {
        // 返回条件
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        // 单层循环逻辑
        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && !flag[i - 1]) {
                continue;
            }
            flag[i] = true;
            sum += candidates[i];
            path.add(candidates[i]);
            backTracking(candidates, target, i + 1, flag);
            sum -= candidates[i];
            path.removeLast();
            flag[i] = false;
        }
    }
}
