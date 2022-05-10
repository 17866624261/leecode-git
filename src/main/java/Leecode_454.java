import java.util.HashMap;
import java.util.Map;

public class Leecode_454 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {-2, -1};
        int[] nums3 = {-1, 2};
        int[] nums4 = {0, 2};
        System.out.println(fourSumCount(nums1,nums2,nums3,nums4));
    }

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        // 求ab数组的和，将其放入hash中
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                } else {
                    map.put(sum, 1);
                }
            }
        }

        // 循环cd数组的和，检查条件
        int count = 0;
        for (int i : nums3) {
            for (int j : nums4) {
                int sum = i + j;
                if (map.containsKey(0 - sum)) {
                    count += map.get(0-sum);
                }
            }
        }
        return count;
    }
}
