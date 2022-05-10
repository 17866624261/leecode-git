import java.util.HashMap;
import java.util.Map;

public class ContinuousArray {

    public static int[] nums = {0, 1, 2};

    public static void main(String[] args) {
        int res = findMaxLength(nums);
        System.out.println(res);
    }

    public static int findMaxLength(int[] nums) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int counter = 0;
        map.put(counter, -1);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1)
                counter++;
            else
                counter--;

            if (map.containsKey(counter)) {
                int pre = map.get(counter);
                max = Math.max(max, i - pre);
            } else {
                map.put(counter, i);
            }
        }

        return max;
    }
}
