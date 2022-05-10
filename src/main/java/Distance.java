import java.util.Scanner;

public class Distance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int f = sc.nextInt();
        int k = sc.nextInt();

        int count = 0;

        int toZero = f;
        int toA = a - f;
        int energy = b;

        if (b < 2 * toA || b < 2 * toZero) {
            System.out.println(-1);
        } else {

            // false为向右移动，true为向左移动
            boolean flag = false;

            while (k > 1) {
                k--;
                if (flag) {
                    // 向左移动
                    if (energy - toA >= 2 * toZero) {
                        energy = energy - a;
                    } else {
                        count++;
                        energy = b - toZero;
                    }
                    flag = false;
                } else {
                    // 向右移动
                    if (energy - toZero >= 2 * toA) {
                        energy = energy - a;
                    } else {
                        count++;
                        energy = b - toA;
                    }
                    flag = true;
                }
            }
            if (energy < a) {
                count++;
            }
            System.out.println(count);
        }
    }
}
