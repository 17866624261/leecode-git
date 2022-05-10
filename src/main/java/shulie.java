import java.util.Scanner;

public class shulie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int result = 1;
        int count = -1;
        while (result != 0) {
            result = isYeah(arr);
            arr[result] = arr[result] - 1;
            count++;
        }
        System.out.println(count);
    }

    public static int isYeah(int[] arr) {
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] < arr[i - 1] || arr[i] < arr[i + 1]) {
                continue;
            } else {
                return i;
            }
        }
        return 0;
    }
}
