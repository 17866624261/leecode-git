import java.util.Scanner;

public class MyWorld {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        String s = sc.next();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c){
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
                case 'S':
                    y--;
                    break;
                case 'N':
                    y++;
                    break;
                case 'U':
                    z++;
                    break;
                case 'D':
                    z--;
                    break;
                default:
                    break;
            }
        }

        System.out.println(x+" "+y+" "+z);
    }
}
