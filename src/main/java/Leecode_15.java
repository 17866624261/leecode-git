import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leecode_15 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, 4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // 因为是排序的，如果第一个元素大于零那么后面怎么加都大于零
            if (nums[i] > 0) {
                return res;
            }
            // 如果本轮最左边元素跟上一轮相等，那么找到的=0的三元组也是相同的，因为是相同的循环方式，跳出本轮循环
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }


            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 相同元素跳过去重
                    while (right > left && nums[left] == nums[left + 1]) left++;
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}
