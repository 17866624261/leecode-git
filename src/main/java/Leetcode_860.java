public class Leetcode_860 {
    public boolean lemonadeChange(int[] bills) {
        int[] mon = new int[3];
        if (bills[0] > 5) {
            return false;
        }
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                mon[0]++;
            }
            if (bills[i] == 10) {
                if (mon[0] <= 0) {
                    return false;
                }
                mon[1]++;
                mon[0]--;
            }
            if (bills[i] == 20) {
                if (mon[0] > 0 && mon[1] > 0) {
                    mon[0]--;
                    mon[1]--;
                } else if (mon[0] >= 3) {
                    mon[0] -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
