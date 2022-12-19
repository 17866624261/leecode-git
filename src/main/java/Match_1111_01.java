import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Match_1111_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[16];
        int count = 0;
        long sum = 0;
        List<Long> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
            if (nums[i] != 0) count+=nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != 0){
                for (int j = nums[i]; j > 0; j--) {
                    sum += i * Math.pow(16, --count);
                }
            }
        }
        while (sum > 0){
            list.add(sum % 10);
            sum /= 10;
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        if (sb.charAt(0) == '0'){
            int i = 1;
            while (sb.charAt(i)==0){
                i++;
            }
            sb.setCharAt(0,sb.charAt(i));
            sb.setCharAt(i,'0');
        }
        System.out.println(sb);
    }
}
