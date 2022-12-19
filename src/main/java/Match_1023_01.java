import java.util.Scanner;

public class Match_1023_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int j = sc.nextInt();
        int w = sc.nextInt();
        long index = 1;
        long res = 0;
        while (j != 0 || w != 0) {
            res += (j & 1) * index;
            j = j >> 1;
            index *= 2;
            res += (w & 1) * index;
            index *= 2;
            w = w >> 1;
        }
        System.out.println(res);
    }
}
