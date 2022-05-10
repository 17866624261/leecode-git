import java.util.Scanner;

public class MaxSubAndExchange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            int ex = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = ex;
            int res = subString(arr);
            if (count < res) {
                count = res;
            }
            ex = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = ex;
        }
        System.out.println(count);
    }

    public static int subString(int[] arr) {
        int len = 0;
        int cur = 0;
        int last = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                last = i;
                if (len < (last - cur ))
                    len = last - cur ;
                cur = i;
            }
        }

        return len;
    }
}
