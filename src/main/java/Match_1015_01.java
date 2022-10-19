import java.util.Scanner;

public class Match_1015_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.nextLine();
        }
        for (int i = 0; i < n; i++) {
            strs[i] = strs[i].toUpperCase();
            if (strs[i].equals("JINGDONG")){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }
}
