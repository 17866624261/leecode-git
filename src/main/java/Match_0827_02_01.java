import java.util.Scanner;

public class Match_0827_02_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        String s = sc.next();
        String up = s.substring(0,k).toUpperCase();
        String low = s.substring(k,s.length()).toLowerCase();
        System.out.println(up+low);
    }
}
