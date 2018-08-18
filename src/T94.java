import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by YLT on 2018/3/28.
 */
public class T94 {
    List<Integer> end = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null){
            return end;
        }
        inorderTraversal(root.left);
        end.add(root.val);
        inorderTraversal(root.right);
        return end;
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> nodes = new Stack<>();
        TreeNode now = root;
        while (now !=null||!nodes.isEmpty()){
            while (now != null){
                nodes.add(now);
                now = now.left;
            }
            now = nodes.pop();
            result.add(now.val);
            now = now.right;
        }
        return result;
    }
}
