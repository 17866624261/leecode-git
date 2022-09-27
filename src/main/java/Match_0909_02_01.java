import java.util.Scanner;

public class Match_0909_02_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        long res = 0;
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
            res += scores[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                res += scores[i] | scores[j];
            }
        }
        System.out.println(res);
    }
}
