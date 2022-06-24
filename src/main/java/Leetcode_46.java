import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_46 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        backTracking(nums);
        return result;
    }

    public void backTracking(int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        // 不需要startIndex，每层都要除掉祖先元素已访问的元素，其他全部都要访问
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backTracking(nums);
            used[i] = false;
            path.removeLast();
        }
    }
}
