import java.util.ArrayDeque;
import java.util.Deque;

public class Offer_59_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        // deque中应该存放比前一个元素小的元素，如果比它大那么替换掉之前的所有元素。
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && queue.peekLast() < nums[i]) {
                queue.removeLast();
            }
            queue.offerLast(nums[i]);
        }
        res[0] = queue.peekFirst();
        for (int i = k; i < nums.length; i++) {
            if (queue.peekFirst() == nums[i - k]) {
                queue.removeFirst();
            }
            while (!queue.isEmpty() && queue.peekLast() < nums[i]) {
                queue.removeLast();
            }
            queue.offerLast(nums[i]);
            res[i - k + 1] = queue.peekFirst();
        }
        return res;
    }
}
