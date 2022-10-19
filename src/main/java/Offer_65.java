public class Offer_65 {
    public int add(int a, int b) {
        return (a^b) + ((a&b)<<1);
    }
}
