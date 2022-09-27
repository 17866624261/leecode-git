import java.util.Scanner;

public class Match_0830_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        revert(arr);
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void revert(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int count = 0;
            if ((num % 10) % 2 == 0){
                continue;
            }
            boolean falg = false;
            while (num != 0){
                count++;
                int cur = (num % 10);
                if (cur % 2 == 0){
                    int temp = arr[i] % 10;
                    arr[i] = arr[i] - cur *(int)Math.pow(10,count-1) + temp * (int)Math.pow(10,count-1) - temp + cur;
                    falg = true;
                    break;
                }else {
                    num /= 10;
                }
            }
            if (!falg){
                arr[i] = -1;
            }
        }
    }
}
