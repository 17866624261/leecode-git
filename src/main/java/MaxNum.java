public class MaxNum {
    public static void main(String[] args) {
        int max = maxNum();
        System.out.println(max);
    }
    public static int maxNum() {
        int[] a = new int[]{7, 6, 2, 4, 1, 8, 9, 10, 3, 44};
        int max = a[0];
        int seMax = a[0];
        for (int i = 1; i < a.length;i++){
            if (max < a[i]){
                seMax=max;
                max = a[i];

            }

        }
        return seMax;
    }


}
