public class Demo01 {
    public static void main(String[] args) {


        int n = 0;
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++)
            {
                for (int k = 1; k <= 4; k++)
                {
                    if (i != j && j != k && i != k)
                    {
                        n = i + j * 10 + k * 100;
                        System.out.println(n);
                    }
                }
            }
        }
    }
}
