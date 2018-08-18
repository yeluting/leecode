import java.util.*;

/**
 * Created by YLT on 2018/8/3.
 */
public class T103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        ArrayList<Integer> nowPath = new ArrayList<>();
        Stack<TreeNode>[] queues = new Stack[2];
        queues[0] = new Stack<>();
        queues[1] = new Stack<>();
        int flag = 0;
        queues[flag].add(root);
        while (!queues[flag].isEmpty()){
            TreeNode now = queues[flag].pop();
            nowPath.add(now.val);
            if (flag == 0){
                if (now.left != null) queues[1-flag].add(now.left);
                if (now.right != null) queues[1-flag].add(now.right);
            }else if (flag == 1){
                if (now.right != null) queues[1-flag].add(now.right);
                if (now.left != null) queues[1-flag].add(now.left);

            }
            if (queues[flag].isEmpty()){
                result.add(new ArrayList<>(nowPath));
                nowPath.clear();
                flag = 1 - flag;
            }
        }
        return result;
    }
}
