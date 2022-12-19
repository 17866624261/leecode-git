import java.util.Scanner;

public class MatchTest_1021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[]{5, 4, 1, 1, 5, 1, 5};
        System.out.println(singleNumber(nums, 3));
    }

    public static int singleNumber(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int total = 0;
            for (int num : nums) {
                total += ((num >> i) & 1);
            }
            if (total % k != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

}
