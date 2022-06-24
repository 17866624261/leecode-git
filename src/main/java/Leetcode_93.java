import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_93 {
    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backTracking(s, 0, 0);
        return result;
    }

    public void backTracking(String s, int startIndex, int pointNum) {
        if (pointNum == 3) {
            if (isValid(s, startIndex, s.length() - 1)) {
                result.add(s);
            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s, startIndex, i)) {
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                pointNum++;
                backTracking(s, i + 2, pointNum);
                pointNum--;
                s = s.substring(0, i + 1) + s.substring(i + 2);
            } else {
                break;
            }
        }
    }

    public boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test93() {
        String s = "25525511135";
        System.out.println(restoreIpAddresses(s));
    }
}
