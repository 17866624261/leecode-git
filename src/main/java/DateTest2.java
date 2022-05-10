import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest2 {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date validateTime = null;
        validateTime = sdf.parse("2021-09-20 15:13:12");

        System.out.println(validateTime.getTime()-new Date().getTime());
        Long orderId = 56322135907L;
        Long detailOrderId = 56322135907L;
        String str = "赔付至商户：京东小金库";
        String[] strs = str.split("：");

        System.out.println(strs[1]);

        Student stu = new Student();
        stu.setId("1");

        System.out.println(stu.getName().length());

        String text = "\"promiseTime\":\"2021-11-20 10:02:09\",\"signPromise\":\"1\"";
//        String ext = JSONUtil.getByPath(JSONUtil.parse(text),"promiseTime").toString();
//        System.out.println(ext);

    }
}

class Student{
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
