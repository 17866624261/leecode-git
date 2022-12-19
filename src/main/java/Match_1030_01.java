public class Match_1030_01 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (i != j && j != k && i != k) {
                        int num = (i * 100 + j * 10 + k);
                        if (num % 3 != 0) {
                            count++;
                            System.out.println(num);
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
