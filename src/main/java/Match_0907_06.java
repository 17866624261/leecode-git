import org.junit.Test;

import java.util.Arrays;

public class Match_0907_06 {

    @Test
    public void test(){
        int[] a = new int[]{6,1,4,6,3,2,7,4};
        System.out.println(pickApples(a,3,2));
    }
    public int pickApples(int[] a,int k,int l){
        if (k + l > a.length){
            return -1;
        }
        int sum = 0;
        if (k + l == a.length){
            for (int i : a) {
                sum += i;
            }
            return sum;
        }
        if (maxSum(a,k)[0] != -1){
            int startIndex = maxSum(a,k)[1];
            sum += maxSum(a,k)[0];
            sum += maxSum(Arrays.copyOfRange(a,0,startIndex),l)[0] > maxSum(Arrays.copyOfRange(a,startIndex+1,a.length),l)[0]?maxSum(Arrays.copyOfRange(a,0,startIndex-1),l)[0]:maxSum(Arrays.copyOfRange(a,startIndex+1,a.length - 1),l)[0];
        }
        return sum;
    }
    public int[] maxSum(int[] a,int len){
        if (len > a.length)
            return new int[]{-1,0};
        int max = 0;
        int startIndex = 0;
        for (int i = 0; i < len - 3; i++) {
            int sum = a[i] + a[i+1] + a[i+2];
            if (sum > max){
                max = sum;
                startIndex = i;
            }
        }
        return new int[]{max,startIndex};
    }
}
