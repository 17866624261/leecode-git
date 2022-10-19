import java.util.Scanner;

public class Match_1015_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if (str.length() == 1) System.out.println(1);
        int pre = 0, next = 1;
        int count = 0;
        while (next < str.length()) {
            if (Math.abs(str.charAt(pre) - str.charAt(next)) == 1) {
                pre = pre + count + 1;
                next++;
            } else {
                count++;
                next++;
            }
        }
        System.out.println(str.length() - count);
    }
}
