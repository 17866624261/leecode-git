import java.util.*;

public class Leecode_347 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(Arrays.toString(topKFrequent(nums, 2)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        //
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        System.out.println(entries);
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(((o1, o2) -> o1.getValue() - o2.getValue()));
        for (Map.Entry<Integer, Integer> entry : entries) {
            queue.offer(entry);
            // 只保留k个元素
            if (queue.size() > k) {
                queue.poll();
            }
        }
        System.out.println(queue);
        for (int i = k - 1; i >= 0; i--) {
            res[i] = queue.poll().getKey();
        }
        return res;
    }
}
