import java.util.Arrays;
import java.util.Scanner;

public class Gym {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int err = 0;

        int[][] dongzuo = new int[n][3];
        int[][] truth = new int[m][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                dongzuo[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                truth[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            if (dongzuo[i][2] == truth[i][2]) {
                // 动作相同
                // 头
                if (truth[i][0] < dongzuo[i][0]) {
                    if (dongzuo[i][0] - truth[i][0]< k) {
                        err++;
                    }
                }
                // 尾
                if (truth[i][1] > dongzuo[i][1]){
                    if (truth[i][1] - dongzuo[i][1] < k){
                        err++;
                    }
                }

            } else {
                // 动作不同
                // 头
                if (dongzuo[i][0] < truth[i][0]) {
                    if (truth[i][0] - dongzuo[i][0] < k) {
                        err++;
                    }
                }
                // 尾
                if (dongzuo[i][1] < truth[i][1]) {
                    if (truth[i][1] - dongzuo[i][1] < k) {
                        err++;
                    }
                }
                // 交叉
                int[] arr = {dongzuo[0][0],dongzuo[0][1],truth[0][0],truth[0][1]};
                Arrays.sort(arr);
                if (arr[2]-arr[1] < k){
                    err++;
                }

            }
        }
        System.out.println(err);
    }
}
