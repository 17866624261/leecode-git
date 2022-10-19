public class Match_1004 {
//    public static void main(String[] args) {
//        System.out.println(getSum(2));
//    }
    public int getSum(int n){
        int sum = 0;
        for (int i = 2; i < n; i=i+2) {
            sum += i;
        }
        return sum;
    }
}
