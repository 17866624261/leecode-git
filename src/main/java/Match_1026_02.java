import java.util.Arrays;
import java.util.Scanner;

public class Match_1026_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        long left = 0, right = Integer.MAX_VALUE;
        while (left < right) {
            long mid = (left + right) >> 1;
            if (check(mid, n, k, arr)) left = mid + 1;
            else right = mid;
        }
        System.out.println(left - 1);
    }

    public static boolean check(long mid, int n, int k, int[] arr) {
        long res = 0;
        for (int i = n / 2; i < n; i++) {
            if (arr[i] < mid) res += mid - arr[i];
            else break;
        }
        return res <= k;
    }

}
