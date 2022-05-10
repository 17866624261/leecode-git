public class IsPli {
    public boolean isPalindrome(int x) {

        // 当整数是负数不是回文；第一个数是0时只有0是回文
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        // 回转的数字大于原数字时判断了一半
        int revert = 0;
        while (x > revert) {
            revert = revert * 10 + x % 10;
            x /= 10;
        }

        // 去除奇数时的中位数
        return (x == revert || x == revert / 10);
    }
}
