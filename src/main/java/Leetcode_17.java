import java.util.ArrayList;
import java.util.List;

public class Leetcode_17 {
    List<String> result = new ArrayList<>();

    public static void main(String[] args) {

    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return result;
        }
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTracking(digits, numString, 0);
        return result;
    }

    StringBuilder temp = new StringBuilder();

    public void backTracking(String digits, String[] numString, int num) {
        if (num == digits.length()) {
            result.add(temp.toString());
            return;
        }
        // 取出对应的字符串
        String str = numString[digits.charAt(num) - '0'];
        for (int i = 0; i < str.length(); i++) {
            // 将字符串中的字符一次放入temp中，进行递归
            temp.append(str.charAt(i));
            backTracking(digits, numString, num + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
