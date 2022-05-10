import java.util.ArrayList;
import java.util.List;

class Result{
    public static List<String> removeBackwards(List<String> array,int index,int howManyToRemove){
        for (int i = index; howManyToRemove>0&&i>=0; i--) {
            array.remove(i);
            howManyToRemove--;
        }
        return array;
    }
}





public class ReDelete {
    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        strs.add("hello");
        strs.add("world");
        strs.add("is");
        strs.add("my");
        strs.add("first");
        strs.add("program");

        List<String> res = Result.removeBackwards(strs,4,6);
        for (String s:res
             ) {
            System.out.println(s);
        }
    }
}
