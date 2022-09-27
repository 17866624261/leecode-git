import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Match_0907_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i < n; i++) {
            queue.offer(sc.nextInt());
        }
        int count = 0;
        while (queue.size() >= m){
            int[] temp = new int[m];
            for (int i = 0; i < m; i++) {
                temp[i] = queue.poll();
            }
            for (int i = 0; i < m - 1; i++) {
                queue.add(temp[i] - temp[m-1]);
            }
            count += temp[m-1];
        }
        System.out.println(count);
    }
}
