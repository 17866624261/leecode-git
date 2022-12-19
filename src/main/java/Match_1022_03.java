import java.util.Scanner;

public class Match_1022_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String arrs = sc.nextLine();
        String[] s = arrs.split(" ");
        int[] arr = new int[s.length];
        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        int left = 0;
        int right = n - 1;
        long sumL = arr[left];
        long sumR = arr[right];
        long maxB = 0;
        while (left < right){
            if (sumL == sumR){
                maxB = sumL;
                left++;
                right--;
                sumL += arr[left];
                sumR += arr[right];
            }else if (sumL < sumR){
                left++;
                sumL += arr[left];
            }else {
                right--;
                sumR += arr[right];
            }
        }
        System.out.println(maxB);
    }

}
