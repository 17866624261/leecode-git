import java.util.LinkedList;
import java.util.Scanner;

public class Match_0814_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean res;

        int nums_size = 0;
        nums_size = in.nextInt();
        int[] nums = new int[nums_size];
        for(int nums_i = 0; nums_i < nums_size; nums_i++) {
            nums[nums_i] = in.nextInt();
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        int k;
        k = Integer.parseInt(in.nextLine().trim());

        res = containsNearbyDuplic(nums, k);
        System.out.println(res);
    }
    public static boolean containsNearbyDuplic(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j] && Math.abs(i-j)<=k){
                    return true;
                }
            }
        }
        return false;
    }
}
