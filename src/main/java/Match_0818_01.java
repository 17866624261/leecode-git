import java.util.Scanner;

public class Match_0818_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        triangle(a,b,c);
        //用例01：triangle(3,4,5)，期望控制台输出"此三角形组成的三角形为直角三角形"
        //用例02：triangle(1,2,3)，期望控制台输出"此三边无法组成三角形"
        //用例03：triangle(2,4,6)，期望控制台输出"此三边无法组成三角形"
        //用例04：triangle(2,7,8)，期望控制台输出"此三角形组成的三角形为钝角三角形"
        //用例04：triangle(3,6,9)，期望控制台输出"此三边无法组成三角形"
    }
    public static void triangle(int a,int b,int c){
        if (a + b > c && a + c > b && b + c > a){
            if (a * a == b * b + c * c || b * b == a * a + c * c || c * c == a * a + b * b) {
                System.out.println("此三角形组成的三角形为直角三角形");
            } else if (a * a > b * b + c * c || b * b > a * a + c * c || c * c > a * a + b * b) {
                System.out.println("此三角形组成的三角形为钝角三角形");
            } else if (a == b && a == c && b == c) {
                System.out.println("此三角形组成的三角形为等边三角形");
            }else {
                System.out.println("此三角形组成的三角形为锐角三角形");
            }
        }else {
            System.out.println("此三边无法组成三角形");
        }
    }
}
