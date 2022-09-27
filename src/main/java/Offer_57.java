import java.util.HashMap;
import java.util.Map;

public class Offer_57 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                res[0] = nums[i];
                res[1] = target - nums[i];
                return res;
            }
            map.put(nums[i],map.getOrDefault(nums[i],1));
        }
        return null;
    }
    public int[] twoSum2(int[] nums, int target) {
         // 排序数组，双指针从头尾对撞
        int i = 0,j = nums.length - 1;
        while (i < j){
            int s = nums[i] + nums[j];
            if (s < target) i++;
            else if (s > target) j--;
            else return new int[]{nums[i],nums[j]};
        }
        return new int[0];
    }
}
