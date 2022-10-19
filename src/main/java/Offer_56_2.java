import java.util.HashMap;
import java.util.Map;

public class Offer_56_2 {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue().equals(1)) {
                return (int) entry.getKey();
            }
        }
        return -1;
    }
}
