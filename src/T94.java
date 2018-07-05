import java.util.ArrayList;
import java.util.List;

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
}
