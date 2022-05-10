import java.util.Scanner;

public class Qiegao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sum = 0;

        int long5 = N/5;
        int i = N%5;
        if (i==0){
            sum += long5*20;
        }else{
            sum += long5*20+(i*4-1);
        }

        System.out.println(sum);
    }
}

