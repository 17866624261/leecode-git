import java.util.Scanner;

public class Distance2 {
    public int result = 10000;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int f = scanner.nextInt();
        int k = scanner.nextInt();
        Distance2 question1009 = new Distance2();
        question1009.function(a,b,f,k,0,1,b);
        if(question1009.result==10000)
        {
            System.out.println(-1);
        }
        else
        {
            System.out.println(question1009.result);
        }
    }
    public void function(int a,int b,int f,int k,int time,int i,int originalB)
    {
        if(b<0)
        {
            return;
        }
        if(k==0)
        {
            result = Math.min(time,result);
        }
        else
        {
            if(b>=a)
            {
                function(a,b-a,f,k-1,time,i+1,originalB);
                if(i%2==1)
                {
                    function(a,originalB-(a-f),f,k-1,time+1,i+1,originalB);
                }
                else
                {
                    function(a,originalB-f,f,k-1,time+1,i+1,originalB);
                }
            }
            else
            {
                if(i%2==1)
                {
                    if(b>=f)
                        function(a,originalB-(a-f),f,k-1,time+1,i+1,originalB);
                }
                else
                {
                    if(b>=(a-f))
                        function(a,originalB-f,f,k-1,time+1,i+1,originalB);
                }
            }

        }

    }


}

