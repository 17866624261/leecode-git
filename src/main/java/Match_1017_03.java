import java.util.Scanner;

public class Match_1017_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int count = 0;
        int record = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        for (int i = 0; i < nums.length; i++) {
            if (record >= 2){
                count++;
                record = 0;
            }
            if (nums[i] % 2 != 0){
                record++;
            }else {
                record = 0;
            }
        }
        System.out.println(count);
    }
}
