import java.util.Arrays;
import java.util.Scanner;

public class Present {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] peo = new int[n];
        int[] pre = new int[m];
        int[] peopr = new int[n];
        Arrays.sort(pre);

        for (int i = 0; i < n; i++) {
            peo[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            pre[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            peopr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int count = 0;
            int price = 0;
            for (int j = 0; j < m; j++) {
                if (pre[j] >= peopr[i] && count < peo[i]) {
                    count++;
                    price += pre[j];
                }
            }
            if (count < peo[i]) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(price + " ");
            }
        }
    }
}
