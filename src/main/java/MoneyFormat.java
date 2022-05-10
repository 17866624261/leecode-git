import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class MoneyFormat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String money = sc.next();

        String res = formatPriceString(money);
        System.out.println(res);

    }

    public static String formatPriceString(String money) {
        BigDecimal newMon = new BigDecimal(money);
        DecimalFormat df = new DecimalFormat("#,##0.00");
        String danwei;
        if (money.length() > 8) {
            newMon = newMon.divide(new BigDecimal(100000000)).setScale(3,BigDecimal.ROUND_HALF_UP);
            danwei = "亿";
            return df.format(newMon) + " " + danwei;
        }
        if (money.length() > 5) {
            newMon = newMon.divide(new BigDecimal(10000)).setScale(3,BigDecimal.ROUND_HALF_UP);
            danwei = "万";
            return df.format(newMon) + " " + danwei;
        }
        danwei = "元";
        return money + " " + danwei;
    }
}
