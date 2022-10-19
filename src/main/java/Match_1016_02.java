import java.util.PriorityQueue;
import java.util.Scanner;

public class Match_1016_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt();
        int[] vol = new int[n];
        PriorityQueue<Integer> queue = new PriorityQueue<>((a1, a2) -> {
            return a2 - a1;
        });
        int sumVol = 0;
        for (int i = 0; i < n; i++) {
            vol[i] = sc.nextInt();
            queue.add(sc.nextInt());
            int maxVol = vol[i] + k - 1;
            if (maxVol >= x) {
                sumVol += vol[i] > x ? vol[i] : x;
            }
        }
        System.out.println(sumVol);
    }
}
