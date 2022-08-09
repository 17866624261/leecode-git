import org.junit.Test;

public class Offer_11 {
    @Test
    public void testMinArray(){
        int[] arr = {2,2,2,0,1};
        System.out.println(minArray(arr));
    }

    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        int middle = 0;
        while (left < right){
            middle = (left + right)/2;
            if (numbers[right] < numbers[middle]){
                left = middle + 1;
            }else if (numbers[right] > numbers[middle]){
                right = middle;
            }else {
                right--;
            }
        }
        return numbers[left];
    }
}
