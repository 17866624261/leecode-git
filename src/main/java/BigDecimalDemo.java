import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class BigDecimalDemo {
    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal("1234500.125").stripTrailingZeros();
        BigDecimal b2 = b1.setScale(2, RoundingMode.HALF_UP);
        BigDecimal b3 = b1.setScale(2, RoundingMode.DOWN);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);

        BigDecimal d1 = new BigDecimal("123.456");
        BigDecimal d2 = new BigDecimal("23.456789");
        System.out.println(d1.divide(d2,10,RoundingMode.HALF_UP));
//        System.out.println(d1.divide(d2));出错，除不尽
        BigDecimal n = new BigDecimal("12.345");
        BigDecimal m = new BigDecimal("0.12");
        BigDecimal[] dr = n.divideAndRemainder(m);
        System.out.println(dr[0]);
        System.out.println(dr[1]);

        BigDecimal c1 = new BigDecimal("123.456");
        BigDecimal c2 = new BigDecimal("123.45600");
        System.out.println(c1.add(c2).setScale(4));
        System.out.println(c1.equals(c2.stripTrailingZeros()));
        System.out.println(c1.compareTo(c2));

        BigDecimal a = new BigDecimal(0.1);
        System.out.println(a.doubleValue());
        BigDecimal b = new BigDecimal("0.1");
        System.out.println("b value is:" + b);

        System.out.println("==================");

        DecimalFormat df = new DecimalFormat("#.00");
        BigDecimal p1 = new BigDecimal("1.23556");
        BigDecimal p2 = new BigDecimal("1.23556").setScale(3, RoundingMode.DOWN);
        System.out.println(df.format(p1));
        System.out.println(p2);
    }
}
