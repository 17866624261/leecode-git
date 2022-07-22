import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Test1 {
    //    public static void main(String[] args) {
//        // 学生表 主键：学号（sid int） 姓名（name varchar）
//        // 课程表 主键：课程号（cid int） 名称（name varchar）
//        // 成绩表 学号(学生表外检) 课程号（课程表外键） 分数
//        select s.sid,s.name,avg() from student s left join course c
//    }
    @Test
    public void test01() {
        //    1
        //  2   3
        // 4 5 6 7
        // 左视图

        // 有向图是否有环

        // n个大白，m个居民核酸检测，每个检测5m钟，问小区封闭的时间
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);
        TreeNode left2 = new TreeNode(6);
        TreeNode right2 = new TreeNode(7);
        root.left = left1;
        root.right = right1;
        right1.left = left2;
        right1.right = right2;
        System.out.println(getLeft(root));
    }

    public List<Integer> getLeft(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        queue.offerFirst(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode cur = queue.pollLast();
                if (i == 0) {
                    res.add(cur.val);
                }
                if (cur.left != null) {
                    queue.offerFirst(cur.left);
                }
                if (cur.right != null) {
                    queue.offerFirst(cur.right);
                }
            }
        }
        return res;
    }
}
