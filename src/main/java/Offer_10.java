import org.junit.Test;

public class Offer_10 {
    @Test
    public void testFib() {
        int n = 100;
        System.out.println(fibonacci2(n));
    }

    // 递归做法
    public int fibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // 保存已经计算出来的数的做法
    public long fibonacci2(int n) {
        int[] res = {0, 1};
        if (n < 2) {
            return res[n];
        }
        long fn_2 = 0;
        long fn_1 = 1;
        long fn = 0;
        for (int i = 2; i <= n; i++) {
            fn = fn_1 + fn_2;
            fn_2 = fn_1;
            fn_1 = fn;
        }
        return fn;
    }
}
