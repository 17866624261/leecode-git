import java.util.Scanner;

public class Match_0904_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[n];
        int max = Math.abs(nums[0]);
        int maxInd = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            if (Math.abs(nums[i])>max){
                max = Math.abs(nums[i]);
                maxInd = i;
            }
        }
        int count = 0;
        int num0 = 0;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if (i == maxInd){
                if (nums[i] > 0){
                    count = count + Math.abs(max - 7);
                    flag = true;
                }
                if (nums[i]<0){
                    count = count + Math.abs(max - 7);
                    flag = false;
                }
            }else {
                if (nums[i] > 0){
                    count = count + (nums[i]-1);
                    flag = true;
                }
                if (nums[i] < 0){
                    flag = false;
                    count = count + (-nums[i] - 1);
                }
                if (nums[i] == 0){
                    count++;
                    num0++;
                }
            }
        }
        if (flag){
            System.out.println(count);
        }else if (num0>0){
            System.out.println(count);
        }else {
            System.out.println(count + 2);
        }
    }
}
