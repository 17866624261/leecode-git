import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Match_0903_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int all = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] x = new int[n][2];
        for(int i = 0;i<n;i++)
        {
            x[i][0] = scanner.nextInt();
            x[i][1] = scanner.nextInt();
        }

        Arrays.sort(x, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        int ans=1,r=x[0][1],nowr=x[0][1];//r代表已买最右 nowr代表已遍历的最右
        //如1-7 3-8 4-10 9-11
        for(int i=1;i<n;++i)
        {
            if(x[i][0]>r+1)//如果超过已买最右 就一定要买一个以达更右
            {
                r=nowr;
                ans++;
            }
            //很显然 如果中间出现了断点 已买最右和已遍历最右都不会再更新
            if(x[i][0]<=r+1)//买完之后看看能不能到最右 或者本身不用买
            {
                if(x[i][1]>nowr)nowr=x[i][1];//已遍历的最右
                if(x[i][1]==all)
                {
                    r=all;
                    ans++;
                    break;
                }
            }
        }
        if(r==all) System.out.println(ans);
        else System.out.println("fail");
    }
}
