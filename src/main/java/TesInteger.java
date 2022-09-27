import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TesInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double sum = 0;
        double avg = 0;
        for (int i = 0; i < 12; i++) {
            double str = sc.nextDouble();
            sum += str;
        }
        avg = sum * 1.0 / 12;
        System.out.printf("$%.2f", avg);
        System.out.println();
    }
}
