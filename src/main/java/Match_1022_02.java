import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Match_1022_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        String[] split = s.split(",");
        double[] res = new double[split.length];
        for (int i = 0; i < split.length; i++) {
            res[i] = Double.parseDouble(split[i]);
        }
        Arrays.sort(res);
        double min = Double.MAX_VALUE;
        int left = -1;
        int right = -1;
        for (int i = n; i <= res.length; i++) {
            for (int j = 0; j < res.length - i + 1; j++) {
                int x = j + i - 1;
                double temp = (res[x] - res[j]) / i;
                if (min > temp) {
                    left = j;
                    right = j + i - 1;
                    min = temp;
                }
            }
        }
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMinimumFractionDigits(4);
        System.out.println(nf.format(res[left]) + "," + nf.format(res[right]));
    }
}
