import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[] task =  new int[x];
        int[] time = new int[y];
        for(int i = 0;i<x;i++)
        {
            task[i] = scanner.nextInt();
        }
        for(int j = 0;j<y;j++)
        {
            String temp = scanner.next();
            time[j] =Integer.parseInt(temp);
        }

        for(int i = 0;i<y;i++)
        {
            int sum = 0;
            int count = 0;
            for(int j = 0;j<x;j++)
            {
                sum+=task[j];
                if(time[i]>=sum)
                {
                    count++;
                }
                else
                {
                    System.out.println(count);
                    break;
                }
            }
        }
    }
}
