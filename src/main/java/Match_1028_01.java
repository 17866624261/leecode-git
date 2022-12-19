import java.util.Scanner;

public class Match_1028_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long res = 0;
        int[] monster = new int[n];
        for (int i = 0; i < n; i++) {
            monster[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (monster[i] % k != 0) {
                res += (monster[i] / k);
            } else {
                res += (monster[i] / k) - 1;
            }
        }
        System.out.println(res);
    }
}
