import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Scanner;

public class Match_0818_02 {
    public static void main(String[] args) {
        fiTail(50);
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        fiTail(n);
        int x;
        //fiTail(1) == 1;
        //fiTail(3) == 2;
        //fiTail(5) == 5;
    }
    public static long fiTail(int n){
        return fib(n,1,1);
    }
    public static long fib(int n,long a,long b)  //尾递归-斐波那契数
    {
        if (n<=2)
        {
            return b;
        }
        else
            return fib(n-1,b,a+b);
    }
}
