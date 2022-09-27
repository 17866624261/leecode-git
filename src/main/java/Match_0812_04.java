import java.util.LinkedList;
import java.util.Scanner;

public class Match_0812_04 {
    private static LinkedList<Integer> path = new LinkedList<>();
    public static int res = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        sc.nextLine();
        if (n < 3){
            System.out.println(0);
        }
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        backTracking(arr,0,n);
        System.out.println(res);
    }
    public static void backTracking(int[] arr,int startIndex,int n){
        if (path.size() == 3){
            if ((path.get(0) - path.get(1) == 2*path.get(1) - path.get(2))){
                res++;
            }
            return;
        }
        for (int i = startIndex; i < n-(3-path.size())+1; i++) {
            path.add(arr[i]);
            backTracking(arr,i+1,n);
            path.removeLast();
        }
    }
}
