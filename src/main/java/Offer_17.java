public class Offer_17 {
    public int[] printNumbers(int n) {
        int length = (int) Math.pow(10,n) - 1;
        int[] res = new int[length];
        for (int i = 1; i <= length; i++) {
            res[i - 1] = i;
        }
        return res;
    }
}
