import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by YLT on 2018/8/3.
 */
public class T98 {
    public boolean isValidBST(TreeNode root) {
        return search(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean search(TreeNode node, long min, long max){
        if (node == null){
            return true;
        }
        if (node.val <= min || node.val >= max){
            return false;
        }

        return search(node.left,min,node.val) && search(node.right,node.val,max);
    }
}
