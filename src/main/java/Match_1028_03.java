import java.util.Scanner;

public class Match_1028_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int count = 0;
                if ((j - i + 1) % 2 == 1 && (j - i + 1) < k - 1){
                    break;
                }
                String cur = s.substring(i, j + 1);
                for (int l = 0; l < cur.length() - 1; l++) {
                    if (cur.charAt(l) != cur.charAt(l + 1)) {
                        count++;
                    }
                    if (count >= k) break;
                }
                if (count < k) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
