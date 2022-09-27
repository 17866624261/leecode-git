import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Offer_41 {
    private Queue<Integer> bigger;// 大顶堆保存较小一半的数
    private Queue<Integer> little;// 小顶堆保存较大一半的数

    public Offer_41() {
        this.bigger = new PriorityQueue<>((a1, a2) -> a2 - a1);
        this.little = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (bigger.size() == little.size()) {
            bigger.offer(num);
            little.offer(bigger.poll());
        } else {
            little.offer(num);
            bigger.offer(little.poll());
        }
    }

    public double findMedian() {
        return little.size() != bigger.size() ? little.peek() : (little.peek() + bigger.peek()) / 2.0;
    }
}
