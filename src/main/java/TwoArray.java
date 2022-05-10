import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TwoArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        while (sc.hasNextInt()){
            arr1.add(sc.nextInt());
        }
        while(sc.hasNextInt()){
            arr2.add(sc.nextInt());
        }
        System.out.println(12%10);
    }
}
