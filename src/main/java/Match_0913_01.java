import java.util.Scanner;

public class Match_0913_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + arr[i]);
                if (rightmost >= n - 1) {
                    System.out.println(true);
                    return;
                }
            }
        }
        System.out.println(false);
    }
}
