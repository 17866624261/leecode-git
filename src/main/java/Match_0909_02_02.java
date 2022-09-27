import java.util.ArrayDeque;
import java.util.Scanner;

public class Match_0909_02_02 {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] x = new String[n];

        for(int i = 0;i<n;i++)
        {
            x[i] = scanner.next();
        }
        label: for(int i = 0;i<x.length;i++)
        {
            String[] split = x[i].split("=");
            if(Cau(split[0])==Cau(split[1]))
            {
                System.out.println("Yes");
            }
            else
            {
                StringBuilder stringBuilder1 = new StringBuilder(split[0]);
                StringBuilder stringBuilder2 = new StringBuilder(split[1]);
                for(int j = 0;j<=stringBuilder1.length();j++)
                {
                    for(int k = 0;k<=9;k++)
                    {
                        stringBuilder1.insert(j,k);
                        if (Cau(stringBuilder1.toString())==Cau(split[1])) {
                            System.out.println("Yes");
                            continue label;
                        }
                        stringBuilder1.deleteCharAt(j);
                    }
                }
                for(int j = 0;j<=stringBuilder2.length();j++)
                {
                    for(int k = 0;k<=9;k++)
                    {
                        stringBuilder2.insert(j,k);
                        if (Cau(split[0])==Cau(stringBuilder2.toString())) {
                            System.out.println("Yes");
                            continue label;
                        }
                        stringBuilder2.deleteCharAt(j);
                    }
                }
                System.out.println("No");
            }
        }

    }
    public static int Cau(String s)
    {
        ArrayDeque<Character> ops = new ArrayDeque<>();
        ArrayDeque<String> count = new ArrayDeque<>();
        int i = 0;
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        while (i<chars.length)
        {
            char t = chars[i];
            if(t>='0' &&t <='9')
            {
                stringBuilder.append(t);

            }
            else if(t == '*')
            {
                count.push(stringBuilder.toString());
                stringBuilder = new StringBuilder();
                ops.push(t);

            }
            else
            {
                count.push(stringBuilder.toString());
                stringBuilder = new StringBuilder();
                while(!ops.isEmpty() && ops.peek() == '*')
                {
                    ops.pop();
                    int pop1 = Integer.parseInt(count.pop());
                    int pop2 = Integer.parseInt(count.pop());
                    count.push(pop1*pop2+"");
                }

                ops.push('+');
            }
            i++;
        }
        if(stringBuilder.length()>0)
        {
            count.push(stringBuilder.toString());
        }
        while (!ops.isEmpty())
        {
            Character pop = ops.pop();
            int pop1 = Integer.parseInt(count.pop());
            int pop2 = Integer.parseInt(count.pop());
            int result = 0;
            switch (pop)
            {
                case '*':
                    result = pop1*pop2;break;
                case '+':
                    result = pop1+pop2;break;
            }
            count.push(result+"");
        }
        return Integer.parseInt(count.pop());
    }
}
