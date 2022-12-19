import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Match_1109_02 {
    public static List<Integer> path = new LinkedList<>();
    public static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        backTracking(nums, 0, 0);
        System.out.println(count);
    }

    public static void backTracking(int[] nums, int start, double sum) {
        if (sum == 1) {
            count++;
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if ((int) (sum + 1.0 / nums[i]) > 1) {
                break;
            } else {
                backTracking(nums, i + 1, sum + (1.0 / nums[i]));
            }
        }
    }
}
