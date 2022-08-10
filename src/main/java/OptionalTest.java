import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        TreeNode node = null;
        System.out.println(Optional.ofNullable(node).map((o)->o.right).isPresent());
    }
}
