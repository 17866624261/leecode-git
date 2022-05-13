import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Leecode_239 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        int rei = 0;
        // 将下标放入双端队列中
        for (int i = 0; i < nums.length; i++) {
            // 将窗口外的元素弹出
            while (!queue.isEmpty() && queue.peek() < i - k + 1) {
                queue.poll();
            }
            // 每次新放入元素检查入口的元素是不是大于要插入的元素，如果不是则删除入口的元素
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offer(i);
            // 在k+1及以后的元素每次循环插入结果集一个元素
            if (i >= k - 1) {
                res[rei++] = nums[queue.peek()];
            }
        }
        return res;
    }
}
