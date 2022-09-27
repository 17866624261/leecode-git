import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Optional;

public class LambdaClass {
    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(2,2);
        map.forEach((k,v)-> System.out.println(v));
        LambdaInterface forEg = LambdaClass::forEg;
//        Optional.ofNullable().map();
        forEg.f();
        LocalDateTime of = LocalDateTime.of(2021, 01, 01, 12, 11, 10);
        System.out.println();
        Converter<String, Integer> function = Integer::valueOf;
        Integer integer = function.convert("123");
        Converter<String, Integer> function1 = Integer::new;
        System.out.println(integer);
    }
    public static void forEg(){
        lambdaInterfaceDemo(()->{
            System.out.println("自定义函数式接口");
        });
    }
    static void lambdaInterfaceDemo(LambdaInterface i){
        System.out.println(i);
    }
}
