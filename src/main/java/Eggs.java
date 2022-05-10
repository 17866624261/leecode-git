public class Eggs {
    static int oldChicken = 1;

    public static void main(String[] args) {

        System.out.println(chicken(8));
    }

    public static int chicken(int n) {
        if (n <= 0) {
            return 0;
        }
        for (int i = 1; i <= n + 1; i++) {
            if ((i + 2) <= n + 1) {
                oldChicken++;
                chicken(n - i - 2);
            }
        }
        return oldChicken;
    }
}
