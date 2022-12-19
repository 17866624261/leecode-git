import java.util.ArrayList;
import java.util.List;

public class TestFor {
    private static int sum = 0;

    public static void main(String[] args) {
        int a=4,b=9;
        System.out.println((--b*a++)/(++a+b--));
    }

//    public static int cal(int source) {
//        if (source < 5) {
//            return source;
//        }
//        return cal(source - 1) + cal(source - 2);
//    }
}
