import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.internal.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resources;
import java.util.Scanner;

@Data
@JsonIgnoreProperties({"name"})
@ToString
@Scope(value = "singleton")
@SpringBootApplication
public class Match_0818_03 {
    @NotNull
    @Getter
    @Setter
    private String name;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        equation(m);
        // 用例01：
        // equation(13)
        // 期望控制台输出：
        // 1+1=2
        // 共有一个等式
    }
    public static void equation(int m){
        int a,b,c,sum = 0;
        for (a = 0 ; a < 1111 ; a++){
            for (b = 0 ; b < 1111 ;b++){
                c = a + b;
                if (sum(a) + sum(b) + sum(c) == m - 4){
                    System.out.println(a+"+"+b+"="+c);
                }
            }
        }
    }
    public static int sum(int n){

        int num = 0;
        int parma[] = {6,2,5,5,4,5,6,3,7,6};

        while(n/10 != 0){
            num += parma[n%10];
            n /= 10;
        }
        num += parma[n];
        return num;
    }
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED,readOnly = true,rollbackFor = Exception.class,timeout = -1)
    public void equation2(int m){
        int a,b,c,sum = 0;
        for (a = 0 ; a < 1111 ; a++){
            for (b = 0 ; b < 1111 ;b++){
                c = a + b;
                if (sum(a) + sum(b) + sum(c) == m - 4){
                    System.out.println(a+"+"+b+"="+c);
                }
            }
        }
    }
}
