import java.util.ArrayList;
import java.util.Scanner;

public class Corn {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();


        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            arr.add(sc.nextInt());
        }

        if (arr.get(K-1)==0){
            System.out.println(0);
            return;
        }

        if (arr.get(K-1)==1){
            int sumLeft = 0;
            int sumRight = 0;
            int next = K+1;
            int cur = K;

            while(arr.get(K-1)!=1){

            }
            System.out.println(Math.max(sumLeft,sumRight));
            return;
        }

        {

        }

    }
}
enum Day{
    MON
}
