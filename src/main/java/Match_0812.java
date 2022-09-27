import java.util.Arrays;
import java.util.Scanner;

public class Match_0812 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int res = 0;
        sc.nextLine();
        int[] preTime = new int[n];
        for (int i = 0; i < n; i++) {
            preTime[i] = sc.nextInt();
        }
        Arrays.sort(preTime);
        int curTime = 0;
        for (int i = 0; i < n; i++) {
            if (curTime + t <= preTime[i]){
                curTime += t;
            }else {
                res++;
            }
        }
        System.out.println(res);
    }
}
