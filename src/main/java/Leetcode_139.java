import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Leetcode_139 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        // valid[i]表示字符串长度为i的时候，是否可以拆分为一个或多个在字典中出现的单词
        boolean[] valid = new boolean[s.length() + 1];
        valid[0] = true;
        Thread thread = new Thread();
        for (int i = 1; i <= s.length(); i++) {
            // 遍历背包
            for (int j = 0; j < i; j++) {
                // 遍历物品
                // 递推到最后是否满足条件
                if (wordDict.contains(s.substring(j, i)) && valid[j]) {
                    valid[i] = true;
                }
            }
        }
        ReentrantLock lock = new ReentrantLock();
        return valid[s.length()];
    }
}
