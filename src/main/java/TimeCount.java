import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class TimeCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String timePattern = sc.nextLine();
        String rules = sc.nextLine();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;

        try {
            date = sdf.parse(timePattern);

        }catch (Exception e){
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        String[] rule = rules.split(" ");
        for(String r:rule){
            int num = Integer.parseInt(r.substring(1,2));
            if (r.indexOf("-")>=0){
                num = -num;
            }
            if (r.indexOf("d")>0)
                calendar.add(Calendar.DAY_OF_YEAR,num);
            if (r.indexOf("h")>0)
                calendar.add(Calendar.HOUR,num);
            if (r.indexOf("W")>0)
                calendar.add(Calendar.WEEK_OF_YEAR,num);
            if (r.indexOf("m")>0)
                calendar.add(Calendar.MINUTE,num);
            if (r.indexOf("s")>0)
                calendar.add(Calendar.SECOND,num);
        }
        date = calendar.getTime();
        String res = sdf.format(date);

        System.out.println(res);

    }
}
