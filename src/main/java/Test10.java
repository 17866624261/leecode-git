public class Test10 {
    public static int i = 3;
    public static void print(){
        System.out.println("i="+i++);
        System.out.println("i="+i);
        add(i);
        System.out.println("i="+i);
        add();
        System.out.println("i="+i);
    }
    public static void add(int j){
        ++j;
    }
    public static void add(){
        ++i;
    }

    public static void main(String[] args) {
        Test10.print();
    }
}
