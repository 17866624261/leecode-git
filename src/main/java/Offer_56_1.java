import java.util.*;

public class Offer_56_1 {
    public int[] singleNumbers(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue().equals(1)) {
                list.add((int) entry.getKey());
            }
        }
        int[] res = list.stream().mapToInt(Integer::valueOf).toArray();
        return res;
    }

    // 使用异或的方法
    public int[] singleNumbers2(int[] nums) {
        int x = 0, y = 0, n = 0, m = 1;
        // 所有数字异或完以后只会留下两个不相同的数字的异或作为结果
        for (int num : nums) {
            n ^= num;
        }
        // 寻找这两个结果异或后第一个等于1的位，这个位是这两个数的不同位，通过这个将所有数分为两组
        // 因为m只有一位为1，所以跟其他数与完只能等于0或者其他数
        while ((n & m) == 0) {
            m <<= 1;
        }
        // 主要将这两个不同的数分到两组中，其他的数分到哪不重要，因为与的是同一个数，所以相同的数肯定会分到一组中
        // 因为m这个位不同，所以两个数跟m与一定为0或者其他数
        for (int num : nums) {
            if ((num & m) != 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }
        return new int[]{x, y};
    }
}
