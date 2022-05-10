public class Lmin {
    public static void main(String[] args) {
        long C = 85899345920L;
        long m = 82033875353L;
        int a = 2628000;
        double H = 0.8;
        double e = 0.0001;
        double Lmin;

        Lmin = Math.pow((Math.sqrt((-2)*Math.log1p(e-1)*a*m)*(Math.pow(H,H)*Math.pow((1-H),(1-H))))/(Math.pow((C-m),H)),1/(1-H));
        System.out.println(Lmin/8);
        System.out.println(Math.log1p(e-1));
    }
}
