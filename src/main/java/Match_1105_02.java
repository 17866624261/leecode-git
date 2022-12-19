public class Match_1105_02 {
    public int find(int[] n, int h) {

        if (n.length > h) {
            return 0;
        }
        int max = 0;
        long sum = 0;
        for (int i : n) {
            max = Math.max(max, i);
            sum += i;
        }

        int first = 0;
        int last = max;
        while (first < last) {
            int middle = (last - first) / 2 + first;

            boolean check = check(middle, h, n, sum);
            if (check) {
                last = middle;
            } else {
                first = middle + 1;
            }
        }

        return check(first, h, n, sum) ? first : 0;
    }

    public boolean check(int k, int h, int[] n, long sum) {
        if (k * h < sum) {
            return false;
        } else {
            for (int i = 0; i < n.length; i++) {
                h -= (n[i] / k) + (n[i] % k != 0 ? 1 : 0);
            }
            if (h >= 0) {
                return true;
            } else {
                return false;
            }
        }
    }
}
