import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Match_0825_02 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        Scanner in = new Scanner(line);
        while (in.hasNextLine()){
            list.add(sc.nextInt());
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        System.out.println(function(arr));
    }
    public static int function(int[] arr){
        int max = 0;
        int first = 0;
        int last = arr.length - 1;
        while (first < last){
            int l = last - first;
            int width = Math.min(arr[first],arr[last]);
            max = Math.max(max,width*l);
            if (arr[first] >= arr[last]){
                first++;
            }else {
                last--;
            }
        }
        return max;
    }
}
