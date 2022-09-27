import java.util.Arrays;
import java.util.Scanner;

public class Match_0830_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] divid = new int[n];
        divid[0] = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (i > 0){
                divid[i] = Math.abs(arr[i]-arr[i-1]);
            }
        }
        Arrays.sort(divid);
        if (n > 2){
            int m1 = divid[n-1];
            int m2 = divid[n-2];
            if (m1 > m2){
                for (int i = 0; i < n - 1; i++) {
                    if (arr[i] + m1 <= arr[i+1]){
                        arr[i] = arr[i] + (m1 - divid[1] + 1)/2;
                    }
                }
            }
            int max = 0;
            for (int i = 0; i < n -1; i++) {
                max = Math.max(max,Math.abs(arr[i] - arr[i+1]));
            }
            System.out.println(max);
        }else {
            System.out.println(0);
        }
    }
}
