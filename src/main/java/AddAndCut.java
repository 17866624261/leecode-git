import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddAndCut {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n*n; i++) {
            arr.add(sc.nextInt());
        }
        int sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
        }

        System.out.println(sum);

    }


}
