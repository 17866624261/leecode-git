import java.util.Scanner;

public class Match_1011_02 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        backTracking('r',x);
        System.out.println();
    }

    public static void backTracking(char c, int x) {
        sb.append(c);
        if (sb.length() > 10) return;
        if (countSubstrings(sb.toString()) == x) {
            return;
        }
        backTracking('r', x);
        backTracking('e', x);
        backTracking('d', x);
        sb.deleteCharAt(sb.length() - 1);
    }

    public static int countSubstrings(String s) {
        int n = s.length();
        int num = 0;
        for (int i = 0; i < 2 * n - 1; i++) {
            int l = i / 2;
            int r = l + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
                num++;
            }
        }
        return num;
    }
}
