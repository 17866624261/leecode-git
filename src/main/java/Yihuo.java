import java.util.List;

public class Yihuo {
    public long solve(int k, List<Integer> a){
        long result =0;

        for (int i = 0; i < a.size(); i++) {
            for (int j = i+1; j < a.size(); j++) {
                long math = ((a.get(i)^a.get(j))*k+(a.get(i)*a.get(j)));
                if (result < math)
                    result = math;
            }
        }

        return result;
    }
}
