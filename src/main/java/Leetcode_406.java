import java.util.Arrays;
import java.util.LinkedList;

public class Leetcode_406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
        LinkedList<int[]> queue = new LinkedList<>();
        for (int[] p : people) {
            // 从后往前插入，局部最优，从而全剧最优
            queue.add(p[1], p);
        }
        return queue.toArray(new int[people.length][]);
    }
}
