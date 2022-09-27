import java.util.Scanner;

public class Match_0903_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
        }
        long[] r = new long[n];
        int res = 0;//极值点
        long mVal = 0;// 极值
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n-i-1; j++) {
                r[i] += x[j]*x[j+i];
            }
            for (int j = n-i; j <= n-1; j++) {
                r[i] += x[j]*x[j+i-n];
            }
        }
        for (int i = 1; i < n - 1; i++) {
            if (((Math.abs(r[i-1]) < Math.abs(r[i]) && Math.abs(r[i+1])< Math.abs(r[i])) || (Math.abs(r[i-1]) > Math.abs(r[i]) && Math.abs(r[i+1])> Math.abs(r[i])))){
                res = i;
                if (Math.abs(r[res]) > Math.abs(mVal)){
                    mVal = r[res];
                }
            }
        }
        if (Math.abs(r[n-1])>Math.abs(mVal)){
            mVal = r[n-1];
        }

        for (int i = 0; i < n; i++) {
            System.out.print(r[i]+" ");
        }
        System.out.println();
        if (res == 0){
            System.out.println("NO");
        }else {
            System.out.println(mVal);
        }
    }
}
