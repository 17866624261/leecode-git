class Insect {
    private int i = 9;
    protected int j;
    private static int x1 = printInit("static insect.x1 initialized");
    Insect(){
        System.out.println("i="+i+",j="+j);
        j = 39;
    }
    static int printInit(String s){
        System.out.println(s);
        return 47;
    }
}
public class Beetle extends Insect{
    private int k = printInit("Beetle.k Initialized");
    private static int x2 = printInit("static Beetle.x2 initialized");
    public Beetle(){
        System.out.println("k="+k+",j="+j);
    }

    public static void main(String[] args) {
        System.out.println("Beetle constructor");
        Beetle b = new Beetle();
    }
}
