import java.util.ArrayList;
import java.util.Scanner;

class GOP {
    //    public static void getGOP(String gopString, int pos, int len) {
//        String substring = gopString.substring(pos, len);
//        char[] chars = substring.toCharArray();
//
//        StringBuilder str = new StringBuilder();
//        str.append("I");
//        for (int i = 1; i < chars.length; i++) {
//            if (chars[i] == 'I') {
//                System.out.println(str);
//                str.setLength(0);
//            }
//            str.append(chars[i]);
//        }
//        System.out.println(str);
//    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int  left = scanner.nextInt();
        int  right = scanner.nextInt();
        String t = s.substring(left,right+1);

        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0;i<t.length();i++)
        {
            if(t.charAt(i)=='I')
            {
                list.add(i);
            }
        }
        if(list.size()>1)
        {
            for(int i = 0;i<list.size()-1;i++)
            {
                System.out.println(t.substring(list.get(i),list.get(i+1)));
            }
        }
    }
}

