import java.util.Scanner;

public class CornIn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int corn = sc.nextInt();
        int first = 2;
        int pre = 2;
        int firstB = 3;
        int count = 1;

        if (corn < first) {
            System.out.println(0 + " " + corn);
            return;
        }
        corn -= first;

        while (corn >= pre + firstB) {
            count++;
            corn -= pre + firstB;
            pre = pre + firstB;
            firstB += 2;
        }

        System.out.println(count + " " + corn);
    }
}
