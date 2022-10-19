import java.util.Scanner;

public class Match_1008_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n + 2];
        height[0] = Integer.MAX_VALUE;
        height[n + 1] = Integer.MAX_VALUE;
        int maxCount = 0;
        int res = 0;
        for (int i = 1; i <= n; i++) {
            height[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            int count = 1;
            int cur = height[i];
            int left = i - 1, right = i + 1;
            while (left >= 1 && height[left] < cur) {
                cur = height[left];
                count++;
                left--;
            }
            cur = height[i];
            while (right <= n && height[right] < cur) {
                cur = height[right];
                count++;
                right++;
            }
            if (count > maxCount) {
                maxCount = count;
                res = i;
            }
        }
        System.out.println(maxCount);
    }
}
