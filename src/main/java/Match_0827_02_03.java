import java.util.Scanner;

public class Match_0827_02_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 6){
            System.out.println(0);
            System.exit(0);
        }
        if (n == 6){
            System.out.println(1);
            System.exit(0);
        }
        long res = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i+3; j <= n; j++) {
                if (j + 2 <= n){
                    res++;
                }
            }
        }

        System.out.println((int)((res*(int) Math.pow(26,n-6)) % 1000000007));
    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        if (n < 6){
//            System.out.println(0);
//            System.exit(0);
//        }
//        if (n == 6){
//            System.out.println(1);
//            System.exit(0);
//        }
//        int res = 0;
//        int k = n - 6;
//        for (int i = 0; i <= k; i++) {
//            for (int j = 0; j <= k; j++) {
//                for (int w = 0; w <= k; w++) {
//                    if (i+j+w == k){
//                        res = (res+(int) (Math.pow(26,i)*Math.pow(26,j)*Math.pow(26,w)))%1000000007;
//                    }
//                }
//            }
//        }
//        System.out.println(res);
//    }
}
