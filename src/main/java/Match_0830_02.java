import java.util.Scanner;

public class Match_0830_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] res = new int[n];
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
        }
        res = getMaxScore(arr,n);
        for (int i = 0; i < n; i++) {
            System.out.println(res[i]);
        }
    }
    public static int[] getMaxScore(int[][] arr,int n){
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            int y = arr[i][0];
            int o = arr[i][1];
            int u = arr[i][2];
            int union = Math.min(y,Math.min(o,u));
            y -= union;
            o -= union;
            u -= union;
            count += union*2;

            if (o > 1){
                count += o-1;
            }
            res[i] = count;
        }
        return res;
    }
}
