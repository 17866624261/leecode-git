import org.junit.Test;

public class Offer_15 {
    @Test
    public void testHamming(){
        int n = 1;
        for (int i = 0; i < 40; i++) {
            System.out.println(n);
            n = n<<1;
        }
    }

    public int hammingWeight(int n) {
        int flag = 1;
        int count = 0;
        while (n!=0){
            if ((n&flag)> 0){
                count++;
            }
            n = n>>>1;
        }
        return count;
    }
    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0){
            count++;
            n = (n-1) & n;
        }
        return count;
    }
    public int hammingWeight3(int n) {
        int flag = 1;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n&flag)> 0){
                count++;
            }
            flag = flag<<1;
        }
        return count;
    }
}
