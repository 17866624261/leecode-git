import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Offer_62 {
    // 模拟算法,时间复杂度很高，消耗时间很长
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>(n);
        int idx = 0;
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }

    // 约瑟夫环，最后存活的元素的下标一定是0，根据最后一轮的下标推出上一轮的下标，一直到推出第一轮的下标就是元素
    public int lastRemaining2(int n, int m) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }
}
