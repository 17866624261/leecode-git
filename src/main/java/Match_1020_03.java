import java.util.Arrays;
import java.util.HashMap;

public class Match_1020_03 {

    public static boolean getK(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        int every = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        every = sum / k;
        for (int i = 0; i < k; i++) {
            if (map.containsKey(every - nums[i])) {
                map.put(nums[i], map.get(nums[i]) - 1);
                map.put(every - nums[i], map.get(every - nums[i]) - 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
