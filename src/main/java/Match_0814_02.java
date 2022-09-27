import java.util.Scanner;

public class Match_0814_02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int hours_size = 0;
        hours_size = in.nextInt();
        int[] hours = new int[hours_size];
        for(int hours_i = 0; hours_i < hours_size; hours_i++) {
            hours[hours_i] = in.nextInt();
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        res = longestWPI(hours);
        System.out.println(String.valueOf(res));
    }
    public static int longestWPI(int[] hours) {
        int max = Integer.MIN_VALUE;
        int normal = 0;
        int out = 0;
        int index = 0;
        for (int i = 0; i < hours.length; i++) {
            if (hours[i] > 8){
                out++;
            }else {
                normal++;
                if (out > normal){
                    if (i - index > max){
                        max = i - index;
                    }
                }
            }
            if (i - index > max){
                max = i - index;
            }
            if (normal >= out){
                normal = 0;
                out=0;
            }
        }
        return max;
    }
}
