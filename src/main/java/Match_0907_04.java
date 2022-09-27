import java.util.Scanner;

public class Match_0907_04 {
    private static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        func(n);
        System.out.println(count);
    }

    public static int func(int n) {
        count = (count + 1) % 1000000007;
        return n <= 3 ? 1 : ((func(n - 1) + func(n - 2) + func(n - 3)) % 1000000007);
    }
}
