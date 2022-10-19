import java.util.Scanner;

public class Match_1015_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] nums = new int[4];
        int[] need = new int[3];
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'r')
                nums[0] += 1;
            if (str.charAt(i) == 'e')
                nums[1] += 1;
            if (str.charAt(i) == 'd')
                nums[2] += 1;
            if (str.charAt(i) == '?')
                nums[3] += 1;
        }
        max = Math.max(Math.max(nums[0], nums[1]), nums[2]);
        int sumNeed = 0;
        for (int i = 0; i < need.length; i++) {
            need[i] = max - nums[i];
            sumNeed += need[i];
        }
        if (sumNeed < nums[3]) {
            int ext = (nums[3] - sumNeed) / 3;
            for (int i = 0; i < need.length; i++) {
                need[i] += ext;
            }
        }
        System.out.println(nchoosek(3,1));
        System.out.println(nchoosek(nums[3],need[0])*nchoosek(nums[3] - need[0],need[1])*nchoosek(nums[3] - need[0] - need[1],need[2]));
    }
    public static int nchoosek(int n, int k){
        k = (k > (n - k)) ? n - k : k;
        if(k <= 1){
            return 1;
        }
        int divisor = n - k + 1;
        int dividend = 1;
        double cnk = 1.0;
        for(int i = 0; i < k; i++){
            cnk *= (double) (divisor + i) / (dividend + i);
        }
        return (int) cnk;
    }
}
