import java.util.Scanner;

public class GetDog {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int d = sc.nextInt();
        int maxLove = -1;

        int[] love = new int[n];
        int[] getPrice = new int[n];
        int[] aliPrice = new int[n];

        for (int i = 0; i < n; i++) {
            love[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            getPrice[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            aliPrice[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (k < getPrice[i])
                continue;

            int budget = d / n * (i + 1);
            if (budget >= aliPrice[i]){
                if (maxLove < love[i]){
                    maxLove = love[i];
                }
            }
        }
        System.out.println(maxLove);
    }
}
