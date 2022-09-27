import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

public class Offer_40 {
    public static void main(String[] args) {
        int[] nums = getLeastNumbers2(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 4);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        PriorityQueue<Integer> queue = new PriorityQueue<>((a1, a2) -> a1 - a2);
        for (int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);
        }
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    public static int[] getLeastNumbers2(int[] arr, int k) {
        int[] res = new int[k];
        PriorityQueue<Integer> queue = new PriorityQueue<>((a1, a2) -> a2 - a1);
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
}
