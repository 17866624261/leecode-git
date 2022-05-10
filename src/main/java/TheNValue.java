import java.util.Scanner;

public class TheNValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x==1 && y==1){
                System.out.println(1);
            }else if (x<y){
                for (int j = 0; j < n; j++) {

                }
            }

        }
    }
}
