public class DefauleTest {
    public static void main(String[] args) {
        int i = 1;
        int j = i++;
        if ((j>++j) && (i++==j)){
            j+=i;
        }
        System.out.println(j);
    }
}
