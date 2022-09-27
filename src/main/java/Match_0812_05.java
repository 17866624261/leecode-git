import java.util.Scanner;

public class Match_0812_05 {
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int[] tree = new int[n+1];
        for (int i = 1; i <= n; i++) {
            tree[i] = sc.nextInt();
        }
        int sum = 0;
        treeBack(1,n,sum,tree);
        System.out.println(max);
    }
    public static void treeBack(int root,int n,int sum,int[] tree){
        if (root > n){
            if (sum > max){
                max = sum;
            }
            return;
        }
        sum += tree[root];
        treeBack(root*2,n,sum,tree);
        treeBack(root*2+1,n,sum,tree);
        sum -= tree[root];
    }
}
