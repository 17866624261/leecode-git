import java.util.Scanner;

public class Match_0904_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[2*n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = n,j = n-1; i < 2*n; i++,j--) {
            arr[i] = arr[j];
        }
        System.out.println(arr[k%(2*n) - 1]);

    }
}
