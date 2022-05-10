import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Waterflow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        List<Integer> index = new ArrayList<>();
        int maxIndex = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==max){
                index.add(i);
            }
        }

        int maxcount = 0;
        for (int i = 0; i < index.size(); i++) {
            int count = 0;

            for (int j = index.get(i) + 1; j < arr.length; j++) {
                if (arr[j] < max) {
                    count++;
                }else {
                    break;
                }
            }
            for (int j = index.get(i) - 1; j >= 0; j--) {
                if (arr[j] < max) {
                    count++;
                }else {
                    break;
                }
            }
            if (count>maxcount){
                maxcount = count;
            }
        }

        System.out.println(maxcount);
    }
}
